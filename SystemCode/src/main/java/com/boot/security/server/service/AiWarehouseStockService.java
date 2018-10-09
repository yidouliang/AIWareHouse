package com.boot.security.server.service;

import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.model.AiWarehouseStock;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Seven.wk
 * Description: AI仓库库存管理的服务接口
 * Created At 2018/09/28
 */
public interface AiWarehouseStockService {

    /**
     * 保存对象
     * @param request
     * @param aiWarehouseStock
     * @return
     */
    ResponseInfo save(HttpServletRequest request,
                      AiWarehouseStock aiWarehouseStock);
}
