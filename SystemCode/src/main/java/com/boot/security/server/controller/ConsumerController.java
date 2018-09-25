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
import com.boot.security.server.dao.ConsumerDao;
import com.boot.security.server.model.Consumer;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    @Autowired
    private ConsumerDao consumerDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Consumer save(@RequestBody Consumer consumer) {
        consumerDao.save(consumer);

        return consumer;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Consumer get(@PathVariable Long id) {
        return consumerDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Consumer update(@RequestBody Consumer consumer) {
        consumerDao.update(consumer);

        return consumer;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return consumerDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Consumer> list(PageTableRequest request) {
                return consumerDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        consumerDao.delete(id);
    }
}
