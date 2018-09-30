package com.boot.security.server.controller;

import java.util.ArrayList;
import java.util.List;

import com.boot.security.server.convert.AiOrderThirdLevel2AiOrderThirdLevelDto;
import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.AiOrderThirdLevelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.AiOrderThirdLevelDao;
import com.boot.security.server.model.AiOrderThirdLevel;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aiOrderThirdLevels")
public class AiOrderThirdLevelController {

    @Autowired
    private AiOrderThirdLevelDao aiOrderThirdLevelDao;

    @Autowired
    private DictDao dictDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiOrderThirdLevel save(@RequestBody AiOrderThirdLevel aiOrderThirdLevel) {
        aiOrderThirdLevelDao.save(aiOrderThirdLevel);

        return aiOrderThirdLevel;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiOrderThirdLevel get(@PathVariable Long id) {
        return aiOrderThirdLevelDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiOrderThirdLevel update(@RequestBody AiOrderThirdLevel aiOrderThirdLevel) {
        aiOrderThirdLevelDao.update(aiOrderThirdLevel);

        return aiOrderThirdLevel;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiOrderThirdLevelDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiOrderThirdLevelDto> list(PageTableRequest request) {
                List<AiOrderThirdLevel> aiOrderThirdLevels = aiOrderThirdLevelDao.list(request.getParams(), request.getOffset(), request.getLimit());
                List<AiOrderThirdLevelDto> aiOrderThirdLevelDtos = new ArrayList<>();
                AiOrderThirdLevel2AiOrderThirdLevelDto.aiOrderThirdLevelAiOrderThirdLevelDto(dictDao,aiOrderThirdLevels,aiOrderThirdLevelDtos);
                return aiOrderThirdLevelDtos;
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiOrderThirdLevelDao.delete(id);
    }
}
