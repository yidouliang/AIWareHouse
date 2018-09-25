package com.boot.security.server.controller;

import com.boot.security.server.dao.OrderThirdLevelDao;
import com.boot.security.server.model.OrderThirdLevel;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;

import java.util.List;


@RestController
@RequestMapping("/orderThirdLevels")
public class OrderThirdLevelController {

    @Autowired
    private OrderThirdLevelDao orderThirdLevelDao;


    @GetMapping()
    @ApiOperation(value = "获取三级订单信息")
    public PageTableResponse list(PageTableRequest request,@RequestParam("firstLevelId") Long fId) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return orderThirdLevelDao.count(request.getParams(),fId);
            }
        }, new ListHandler() {

            @Override
            public List<OrderThirdLevel> list(PageTableRequest request) {
                return orderThirdLevelDao.listThirdLevel(request.getParams(),request.getOffset(),request.getLimit(),fId);
            }
        }).handle(request);
    }
}
