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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public AiMktBox save(@RequestBody AiMktBoxVo aiMktBoxVo, HttpServletRequest request) {
        //获取运营商Id,存入AiMktBox中
        SysUser user = userService.getTokenUser(request);
        AiOperator aiOperator = aiOperatorDao.getAiOperatorByUserId(user.getId());
        AiMktBox aiMktBox = new AiMktBox();
        AiMktBoxVo2AiBox.aiMktBoxVo2AiBox(aiMktBoxVo,aiMktBox);
        aiMktBox.setBoxperson(aiOperator.getId());
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
        //aiMktBoxDao.getById(aiMktBox.)
        aiMktBoxDao.update(aiMktBox);

        return aiMktBox;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiMktBoxDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiMktBoxVo> list(PageTableRequest request) {
                List<AiMktBox> aiMktBoxList =  aiMktBoxDao.list(request.getParams(), request.getOffset(), request.getLimit());
                List<AiMktBoxVo> aiMktBoxVoList = new ArrayList<>();
                AiMktBoxVo2AiBox.aiMktBoxList2AiBoxList(dictDao,aiMktBoxVoList,aiMktBoxList);
                return aiMktBoxVoList;
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiMktBoxDao.delete(id);
    }
}
