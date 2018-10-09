package com.boot.security.server.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.boot.security.server.convert.AiMktBoxVo2AiBox;
import com.boot.security.server.dao.AiOperatorDao;
import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.AiMktBoxVo;
import com.boot.security.server.filter.TokenFilter;
import com.boot.security.server.model.AiOperator;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.TokenService;
import com.boot.security.server.service.UserService;
import com.boot.security.server.service.impl.UserServiceImpl;
import com.mchange.v2.beans.BeansUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.AiMktBoxDao;
import com.boot.security.server.model.AiMktBox;

import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/aiMktBoxs")
public class AiMktBoxController {

    @Autowired
    private AiMktBoxDao aiMktBoxDao;

    @Autowired
    private DictDao dictDao;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AiOperatorDao aiOperatorDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiMktBox save(@RequestBody AiMktBoxVo aiMktBoxVo, HttpServletRequest request,
                         @RequestParam(value = "boxperson",required = false) Long boxperson, Model model) {
        //获取运营商Id,存入AiMktBox中
        SysUser user = userService.getTokenUser(request);
        AiOperator aiOperator = aiOperatorDao.getById(user.getOperatorid());
        AiMktBox aiMktBox = new AiMktBox();
        AiMktBoxVo2AiBox.aiMktBoxVo2AiBox(aiMktBoxVo, aiMktBox);
        //如果是为关联运营者的用户(即管理员等)
        //需要先创建运营商后再创建AI货柜或者无人超市
        if(aiOperator!=null) {

            aiMktBox.setBoxperson(aiOperator.getId());
            //如果是管理员操作就提示(此处需要添加后台验证)

        }else{
            //当获取运营商为空的时候代表登录user为高级的管理员
            //boxperson是从运营商管理页面进行添加的时候传过来的
            aiMktBox.setBoxperson(boxperson);
            //如果是管理员操作跳转到盒子管理
            model.addAttribute("wherego",true);
        }
        aiMktBoxDao.save(aiMktBox);

        return aiMktBox;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiMktBox get(@PathVariable Long id) {
        return aiMktBoxDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiMktBox update(@RequestBody AiMktBox aiMktBox) {
        aiMktBoxDao.update(aiMktBox);

        return aiMktBox;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request,HttpServletRequest servletRequest) {
        //根据运营商id判断,如果不是运营商就返回全部box
        //先获取用户
        SysUser user = userService.getTokenUser(servletRequest);
        //从Operator表中查询相关的运营商
        AiOperator aiOperator = aiOperatorDao.getById(user.getOperatorid());

        if(aiOperator == null){
            return new PageTableHandler(new CountHandler() {

                @Override
                public int count(PageTableRequest request) {
                    return aiMktBoxDao.count(request.getParams(),null);
                }
            }, new ListHandler() {

                @Override
                public List<AiMktBoxVo> list(PageTableRequest request) {
                    List<AiMktBox> aiMktBoxList =  aiMktBoxDao.list(request.getParams(), request.getOffset(), request.getLimit(),null);
                    //判断盒子是否需要缴费,若欠费就更新状态
                    for (AiMktBox box:aiMktBoxList
                    ) {
                        Date now = new Date();
                        if(box.getEnddate().before(now)){
                            //支付状态 0欠费 1已缴费
                            box.setPaystate(0);
                            aiMktBoxDao.update(box);
                        }
                    }
                    List<AiMktBoxVo> aiMktBoxVoList = new ArrayList<>();
                    AiMktBoxVo2AiBox.aiMktBoxList2AiBoxList(dictDao,aiMktBoxVoList,aiMktBoxList);
                    return aiMktBoxVoList;
                }
            }).handle(request);
        }else {
            return new PageTableHandler(new CountHandler() {

                @Override
                public int count(PageTableRequest request) {
                    return aiMktBoxDao.count(request.getParams(), aiOperator.getId());
                }
            }, new ListHandler() {

                @Override
                public List<AiMktBoxVo> list(PageTableRequest request) {
                    List<AiMktBox> aiMktBoxList = aiMktBoxDao.list(request.getParams(), request.getOffset(), request.getLimit(), aiOperator.getId());
                    //判断盒子是否需要缴费,若欠费就更新状态
                    for (AiMktBox box : aiMktBoxList
                    ) {
                        Date now = new Date();
                        if (box.getEnddate().before(now)) {
                            //支付状态 0欠费 1已缴费
                            box.setPaystate(0);
                            aiMktBoxDao.update(box);
                        }
                    }
                    List<AiMktBoxVo> aiMktBoxVoList = new ArrayList<>();
                    AiMktBoxVo2AiBox.aiMktBoxList2AiBoxList(dictDao, aiMktBoxVoList, aiMktBoxList);
                    return aiMktBoxVoList;
                }
            }).handle(request);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiMktBoxDao.delete(id);
    }

    @GetMapping("/checkUser")
    @ApiOperation(value = "鉴别用户是运营商还是高级管理员")
    public boolean checkUser(HttpServletRequest request){
        //先获取用户
        SysUser user = userService.getTokenUser(request);
        //从Operator表中查询相关的运营商
        AiOperator aiOperator = aiOperatorDao.getById(user.getOperatorid());
        //判断是否为空,为空返回false提示需要先添加运营商从运营商页面添加
        if(aiOperator!=null){
            return true;
        }else {
            return false;
        }
    }
}
