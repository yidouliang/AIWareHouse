package com.boot.security.server.service;

import com.boot.security.server.model.AiWarehouseStock;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Seven.wk
 * Description: AI仓库库存管理的服务接口
 * Created At 2018/09/28
 */
public interface AiWarehouseStockService {

    /**
     * 填充AIWarehouse实体类中的部分字段内容
     * @param request
     * @param aiWarehouseStock
     * @return
     */
    AiWarehouseStock paddingField(HttpServletRequest request,
                                  AiWarehouseStock aiWarehouseStock);
}
