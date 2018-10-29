package com.boot.security.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot.security.server.dto.AiCupboardInventoryInstDto;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.AiCupboardInventoryInstService;
import com.boot.security.server.service.UserService;
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
import com.boot.security.server.dao.AiCupboardInventoryInstDao;
import com.boot.security.server.model.AiCupboardInventoryInst;

import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/aiCupboardInventoryInsts")
public class AiCupboardInventoryInstController {

    @Autowired
    private AiCupboardInventoryInstDao aiCupboardInventoryInstDao;

    @Autowired
    private AiCupboardInventoryInstService aiCupboardInventoryInstService;

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "保存")
    public ResponseInfo save(@RequestBody AiCupboardInventoryInst aiCupboardInventoryInst,
                             HttpServletRequest request) {
        return aiCupboardInventoryInstService.save(request, aiCupboardInventoryInst);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiCupboardInventoryInst get(@PathVariable Long id) {
        return aiCupboardInventoryInstDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public ResponseInfo update(@RequestBody AiCupboardInventoryInst aiCupboardInventoryInst) {

        return aiCupboardInventoryInstService.update(aiCupboardInventoryInst);
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request,
                                  HttpServletRequest httpServletRequest) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiCupboardInventoryInstDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiCupboardInventoryInstDto> list(PageTableRequest request) {
                SysUser user = userService.getTokenUser(httpServletRequest);
                if(user.getOperatorid() != null) {
                    Map<String, Object> map = request.getParams();
                    map.put("operatorid", user.getOperatorid());
                    request.setParams(map);
                }
                return aiCupboardInventoryInstDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiCupboardInventoryInstDao.delete(id);
    }
}
