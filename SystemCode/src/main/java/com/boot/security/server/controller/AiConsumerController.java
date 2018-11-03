package com.boot.security.server.controller;

import com.boot.security.server.dao.AiConsumerDao;
import com.boot.security.server.dto.AiConsumerDto;
import com.boot.security.server.model.AiConsumer;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.AiConsumerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aiConsumers")
public class AiConsumerController {

    @Autowired
    private AiConsumerDao aiConsumerDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiConsumer save(@RequestBody AiConsumer aiConsumer) {
        aiConsumerDao.save(aiConsumer);

        return aiConsumer;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiConsumer get(@PathVariable Long id) {
        return aiConsumerDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiConsumer update(@RequestBody AiConsumer aiConsumer) {
        aiConsumerDao.update(aiConsumer);

        return aiConsumer;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiConsumerDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiConsumerDto> list(PageTableRequest request) {
                List<AiConsumerDto> consumers = aiConsumerDao.list(request.getParams(), request.getOffset(), request.getLimit());
                return consumers;
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiConsumerDao.delete(id);
    }

}
