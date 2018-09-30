package com.boot.security.server.controller;

import java.util.ArrayList;
import java.util.List;

import com.boot.security.server.convert.AiConsumer2AiConsumerDto;
import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.AiConsumerDto;
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
import com.boot.security.server.dao.AiConsumerDao;
import com.boot.security.server.model.AiConsumer;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aiConsumers")
public class AiConsumerController {

    @Autowired
    private AiConsumerDao aiConsumerDao;

    @Autowired
    private DictDao dictDao;

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
                List<AiConsumer> consumers = aiConsumerDao.list(request.getParams(), request.getOffset(), request.getLimit());
                List<AiConsumerDto> consumerDtos = new ArrayList<>();
                AiConsumer2AiConsumerDto.aiConsumerList2AiConsumerDtoList(consumers,consumerDtos,dictDao);
                return consumerDtos;
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiConsumerDao.delete(id);
    }
}
