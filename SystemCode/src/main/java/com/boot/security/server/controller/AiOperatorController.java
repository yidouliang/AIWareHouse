package com.boot.security.server.controller;

import java.util.List;

import com.boot.security.server.form.AiOperatorForm;
import com.boot.security.server.service.AiMktBoxService;
import com.boot.security.server.service.impl.AiOperatorServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
import com.boot.security.server.dao.AiOperatorDao;
import com.boot.security.server.model.AiOperator;

import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@RestController
@RequestMapping("/aiOperators")
public class AiOperatorController {

    @Autowired
    private AiOperatorDao aiOperatorDao;

    @Autowired
    private AiMktBoxService aiMktBoxService;

    @Autowired
    private AiOperatorServiceImpl aiOperatorService;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiOperator save(@RequestBody @Valid AiOperatorForm aiOperatorForm, BindingResult bindingResult) {
        AiOperator aiOperator = new AiOperator();
        BeanUtils.copyProperties(aiOperatorForm,aiOperator);
        aiOperatorDao.save(aiOperator);

        return aiOperator;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiOperator get(@PathVariable Long id) {
        return aiOperatorDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiOperator update(@RequestBody AiOperator aiOperator) {
        aiOperatorDao.update(aiOperator);

        return aiOperator;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiOperatorDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiOperator> list(PageTableRequest request) {
                List<AiOperator> aiOperators = aiOperatorService.listAndUpdateOwnNum(request.getParams(), request.getOffset(), request.getLimit());
//                //获取拥有盒子的个数(不建议循环加查询,以后优化)
//                for (AiOperator aiOperator: aiOperators
//                     ) {
//                    aiOperator.setOwernum(aiMktBoxService.getBoxCountByOperatorId(aiOperator.getId()));
//                    aiOperatorDao.update(aiOperator);
//                }
                return aiOperators;
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiOperatorDao.delete(id);
    }
}
