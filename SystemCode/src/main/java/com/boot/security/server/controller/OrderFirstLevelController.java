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
import com.boot.security.server.dao.OrderFirstLevelDao;
import com.boot.security.server.model.OrderFirstLevel;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/orderFirstLevels")
public class OrderFirstLevelController {

    @Autowired
    private OrderFirstLevelDao orderFirstLevelDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public OrderFirstLevel save(@RequestBody OrderFirstLevel orderFirstLevel) {
        orderFirstLevelDao.save(orderFirstLevel);

        return orderFirstLevel;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public OrderFirstLevel get(@PathVariable Long id) {
        return orderFirstLevelDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public OrderFirstLevel update(@RequestBody OrderFirstLevel orderFirstLevel) {
        orderFirstLevelDao.update(orderFirstLevel);

        return orderFirstLevel;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return orderFirstLevelDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<OrderFirstLevel> list(PageTableRequest request) {
                return orderFirstLevelDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        orderFirstLevelDao.delete(id);
    }
}
