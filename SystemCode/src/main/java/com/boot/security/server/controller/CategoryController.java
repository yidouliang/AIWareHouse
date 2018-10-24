package com.boot.security.server.controller;

import java.util.List;

import com.boot.security.server.dto.CategoryDto;
import com.boot.security.server.dto.LinkageDto;
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
import com.boot.security.server.dao.CategoryDao;
import com.boot.security.server.model.Category;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Category save(@RequestBody Category category) {
        categoryDao.save(category);

        return category;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Category get(@PathVariable Long id) {
        return categoryDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Category update(@RequestBody Category category) {
        categoryDao.update(category);

        return category;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return categoryDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Category> list(PageTableRequest request) {
                return categoryDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        categoryDao.delete(id);
    }

    @GetMapping("/twoLinkage")
    @ApiOperation(value = "获得二级分类信息")
    public List<LinkageDto> notLeafLinkage() {
        return categoryDao.twoLinkage();
    }

    @GetMapping("/threeLinkage")
    @ApiOperation(value = "获得三级分类信息")
    public List<LinkageDto> linkage() {
        return categoryDao.threeLinkage();
    }

    @GetMapping("/categories")
    @ApiOperation(value = "获取所有分类信息")
    public List<CategoryDto> categoryDtos() {
        return categoryDao.categories();
    }
}
