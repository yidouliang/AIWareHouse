package com.boot.security.server.service;

import com.boot.security.server.dto.OrderDTO;

/**
 * Created By Seven.wk
 * Description: 三级订单的服务接口
 * Created At 2018/11/15
 */
public interface AiOrderThirdLevelService {

    void createThirdOrder(String orderCode, OrderDTO orderDTO);

}
