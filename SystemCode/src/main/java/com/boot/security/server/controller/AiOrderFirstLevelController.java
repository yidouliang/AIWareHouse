package com.boot.security.server.controller;

import java.util.ArrayList;
import java.util.List;

import com.boot.security.server.convert.AiOrderFIrstLevel2AiOrderFirstLevelDto;
import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.AiOrderFirstLevelDto;
import com.boot.security.server.model.AiOperator;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.UserService;
import com.boot.security.server.service.impl.AiOperatorServiceImpl;
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
import com.boot.security.server.dao.AiOrderFirstLevelDao;
import com.boot.security.server.model.AiOrderFirstLevel;

import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/aiOrderFirstLevels")
public class AiOrderFirstLevelController {

    @Autowired
    private AiOrderFirstLevelDao aiOrderFirstLevelDao;

    @Autowired
    private DictDao dictDao;

    @Autowired
    private UserService userService;

    @Autowired
    private AiOperatorServiceImpl aiOperatorService;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiOrderFirstLevel save(@RequestBody AiOrderFirstLevel aiOrderFirstLevel) {
        aiOrderFirstLevelDao.save(aiOrderFirstLevel);

        return aiOrderFirstLevel;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiOrderFirstLevel get(@PathVariable Long id) {
        return aiOrderFirstLevelDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiOrderFirstLevel update(@RequestBody AiOrderFirstLevel aiOrderFirstLevel) {
        aiOrderFirstLevelDao.update(aiOrderFirstLevel);

        return aiOrderFirstLevel;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request, HttpServletRequest servletRequest) {
        SysUser user = userService.getTokenUser(servletRequest);
        AiOperator aiOperator = aiOperatorService.getAiOperatorByUserId(user.getId());
        if(aiOperator != null){
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiOrderFirstLevelDao.count(request.getParams(),aiOperator.getId());
            }
        }, new ListHandler() {

            @Override
            public List<AiOrderFirstLevelDto> list(PageTableRequest request) {
                List<AiOrderFirstLevelDto> aiOrderFirstLevelDtos = new ArrayList<>();
                List<AiOrderFirstLevel> aiOrderFirstLevels = aiOrderFirstLevelDao.list(request.getParams(),
                        request.getOffset(), request.getLimit(),aiOperator.getId());
                AiOrderFIrstLevel2AiOrderFirstLevelDto.aiOrderFIrstLevelAiOrderFirstLevelDto(dictDao,aiOrderFirstLevels,aiOrderFirstLevelDtos);
                return aiOrderFirstLevelDtos;
            }
        }).handle(request);
        }else{
            return new PageTableHandler(new CountHandler() {

                @Override
                public int count(PageTableRequest request) {
                    return aiOrderFirstLevelDao.count(request.getParams(),null);
                }
            }, new ListHandler() {

                @Override
                public List<AiOrderFirstLevelDto> list(PageTableRequest request) {
                    List<AiOrderFirstLevelDto> aiOrderFirstLevelDtos = new ArrayList<>();
                    List<AiOrderFirstLevel> aiOrderFirstLevels = aiOrderFirstLevelDao.list(request.getParams(),
                            request.getOffset(), request.getLimit(),null);
                    AiOrderFIrstLevel2AiOrderFirstLevelDto.aiOrderFIrstLevelAiOrderFirstLevelDto(dictDao,aiOrderFirstLevels,aiOrderFirstLevelDtos);
                    return aiOrderFirstLevelDtos;
                }
            }).handle(request);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiOrderFirstLevelDao.delete(id);
    }
}
