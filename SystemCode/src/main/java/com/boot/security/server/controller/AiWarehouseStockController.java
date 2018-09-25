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
import com.boot.security.server.dao.AiWarehouseStockDao;
import com.boot.security.server.model.AiWarehouseStock;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aiWarehouseStocks")
public class AiWarehouseStockController {

    @Autowired
    private AiWarehouseStockDao aiWarehouseStockDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiWarehouseStock save(@RequestBody AiWarehouseStock aiWarehouseStock) {
        aiWarehouseStockDao.save(aiWarehouseStock);

        return aiWarehouseStock;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiWarehouseStock get(@PathVariable Long id) {
        return aiWarehouseStockDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiWarehouseStock update(@RequestBody AiWarehouseStock aiWarehouseStock) {
        aiWarehouseStockDao.update(aiWarehouseStock);

        return aiWarehouseStock;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiWarehouseStockDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiWarehouseStock> list(PageTableRequest request) {
                return aiWarehouseStockDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiWarehouseStockDao.delete(id);
    }
}
