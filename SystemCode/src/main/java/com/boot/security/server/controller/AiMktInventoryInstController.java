package com.boot.security.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot.security.server.dto.AiMktInventoryInstDto;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.AiMktInventoryInstService;
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
import com.boot.security.server.dao.AiMktInventoryInstDao;
import com.boot.security.server.model.AiMktInventoryInst;

import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/aiMktInventoryInsts")
public class AiMktInventoryInstController {

    @Autowired
    private AiMktInventoryInstDao aiMktInventoryInstDao;

    @Autowired
    private AiMktInventoryInstService aiMktInventoryInstService;

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "保存")
    public ResponseInfo save(@RequestBody AiMktInventoryInst aiMktInventoryInst,
                             HttpServletRequest request) {
        return aiMktInventoryInstService.save(request, aiMktInventoryInst);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiMktInventoryInst get(@PathVariable Long id) {
        return aiMktInventoryInstDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public ResponseInfo update(@RequestBody AiMktInventoryInst aiMktInventoryInst) {
        return aiMktInventoryInstService.update(aiMktInventoryInst);
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request,
                                  HttpServletRequest httpServletRequest) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiMktInventoryInstDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiMktInventoryInstDto> list(PageTableRequest request) {
                SysUser user = userService.getTokenUser(httpServletRequest);
                if(user.getOperatorid() != null) {
                    Map<String, Object> map = request.getParams();
                    map.put("operatorid", user.getOperatorid());
                    request.setParams(map);
                }
                return aiMktInventoryInstDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiMktInventoryInstDao.delete(id);
    }
}
