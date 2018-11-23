package com.boot.security.server.service;

import com.boot.security.server.dto.OrderDTO;
import com.boot.security.server.dto.OrderInfoDTO;

import java.util.List;

public interface AiOrderFirstLevelService {

    boolean deleteOrder(Long id);

    String createOrder(OrderDTO orderDTO);

    List<OrderInfoDTO> getOrderInfo(String consumerId);

}
