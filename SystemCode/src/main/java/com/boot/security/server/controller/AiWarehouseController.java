package com.boot.security.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.AiWarehouseDao;
import com.boot.security.server.model.AiWarehouse;

import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/aiWarehouses")
public class AiWarehouseController {

    @Autowired
    private AiWarehouseDao aiWarehouseDao;

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiWarehouse save(@RequestBody AiWarehouse aiWarehouse,
                            HttpServletRequest request) {
        SysUser user = userService.getTokenUser(request);
        if(user.getOperatorid() != null) {
            aiWarehouse.setOperatorid(user.getOperatorid());
        }
        aiWarehouseDao.save(aiWarehouse);

        return aiWarehouse;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiWarehouse get(@PathVariable Long id) {
        return aiWarehouseDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiWarehouse update(@RequestBody AiWarehouse aiWarehouse) {
        aiWarehouseDao.update(aiWarehouse);

        return aiWarehouse;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request,
                                  HttpServletRequest httpServletRequest) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiWarehouseDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiWarehouse> list(PageTableRequest request) {
                SysUser user = userService.getTokenUser(httpServletRequest);
                if(user.getOperatorid() != null) {
                    Map<String, Object> m = new HashMap<>();
                    m.put("operatorid", user.getOperatorid());
                    request.setParams(m);
                }
                return aiWarehouseDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiWarehouseDao.delete(id);
    }
}
