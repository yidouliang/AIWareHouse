package com.boot.security.server.service;

import com.boot.security.server.dto.OrderDTO;
import com.boot.security.server.dto.OrderInfoDetailDTO;
import com.boot.security.server.model.AiOrderThirdLevel;

import java.util.List;

/**
 * Created By Seven.wk
 * Description: 三级订单的服务接口
 * Created At 2018/11/15
 */
public interface AiOrderThirdLevelService {

    void createThirdOrder(String orderCode, OrderDTO orderDTO);

    List<OrderInfoDetailDTO> getOrderInfoDetail(String firstLevelId);

    List<AiOrderThirdLevel> getOrderDetailByPserialnumber(String pserialnumber);
}
