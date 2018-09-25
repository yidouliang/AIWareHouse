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
import com.boot.security.server.dao.ResourceproductDao;
import com.boot.security.server.model.Resourceproduct;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/resourceproducts")
public class ResourceproductController {

    @Autowired
    private ResourceproductDao resourceproductDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Resourceproduct save(@RequestBody Resourceproduct resourceproduct) {
        resourceproductDao.save(resourceproduct);

        return resourceproduct;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Resourceproduct get(@PathVariable Long id) {
        return resourceproductDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Resourceproduct update(@RequestBody Resourceproduct resourceproduct) {
        resourceproductDao.update(resourceproduct);

        return resourceproduct;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return resourceproductDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Resourceproduct> list(PageTableRequest request) {
                return resourceproductDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        resourceproductDao.delete(id);
    }
}
