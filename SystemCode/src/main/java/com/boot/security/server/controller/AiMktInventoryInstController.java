package com.boot.security.server.controller;

import java.util.List;

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

    @PostMapping
    @ApiOperation(value = "保存")
    public AiMktInventoryInst save(@RequestBody AiMktInventoryInst aiMktInventoryInst,
                                   HttpServletRequest request) {

        //aiMktInventoryInstDao.save(aiMktInventoryInst);

        return aiMktInventoryInst;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiMktInventoryInst get(@PathVariable Long id) {
        return aiMktInventoryInstDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiMktInventoryInst update(@RequestBody AiMktInventoryInst aiMktInventoryInst) {
        aiMktInventoryInstDao.update(aiMktInventoryInst);

        return aiMktInventoryInst;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiMktInventoryInstDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiMktInventoryInst> list(PageTableRequest request) {
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
