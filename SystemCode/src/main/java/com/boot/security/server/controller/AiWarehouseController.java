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
import com.boot.security.server.dao.AiWarehouseDao;
import com.boot.security.server.model.AiWarehouse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aiWarehouses")
public class AiWarehouseController {

    @Autowired
    private AiWarehouseDao aiWarehouseDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiWarehouse save(@RequestBody AiWarehouse aiWarehouse) {
        aiWarehouseDao.save(aiWarehouse);

        return aiWarehouse;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiWarehouse get(@PathVariable Long id) {
        return aiWarehouseDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiWarehouse update(@RequestBody AiWarehouse aiWarehouse) {
        aiWarehouseDao.update(aiWarehouse);

        return aiWarehouse;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiWarehouseDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiWarehouse> list(PageTableRequest request) {
                return aiWarehouseDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiWarehouseDao.delete(id);
    }
}
