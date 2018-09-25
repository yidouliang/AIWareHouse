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
import com.boot.security.server.dao.MktBoxDao;
import com.boot.security.server.model.MktBox;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mktBoxs")
public class MktBoxController {

    @Autowired
    private MktBoxDao mktBoxDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public MktBox save(@RequestBody MktBox mktBox) {
        mktBoxDao.save(mktBox);

        return mktBox;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public MktBox get(@PathVariable Long id) {
        return mktBoxDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public MktBox update(@RequestBody MktBox mktBox) {
        mktBoxDao.update(mktBox);

        return mktBox;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return mktBoxDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<MktBox> list(PageTableRequest request) {
                return mktBoxDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        mktBoxDao.delete(id);
    }
}
