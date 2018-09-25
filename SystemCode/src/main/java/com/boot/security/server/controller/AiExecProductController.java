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
import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.model.AiExecProduct;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aiExecProducts")
public class AiExecProductController {

    @Autowired
    private AiExecProductDao aiExecProductDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiExecProduct save(@RequestBody AiExecProduct aiExecProduct) {
        aiExecProductDao.save(aiExecProduct);

        return aiExecProduct;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiExecProduct get(@PathVariable Long id) {
        return aiExecProductDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiExecProduct update(@RequestBody AiExecProduct aiExecProduct) {
        aiExecProductDao.update(aiExecProduct);

        return aiExecProduct;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiExecProductDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiExecProduct> list(PageTableRequest request) {
                return aiExecProductDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiExecProductDao.delete(id);
    }
}
