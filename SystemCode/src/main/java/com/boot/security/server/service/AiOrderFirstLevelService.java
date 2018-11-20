package com.boot.security.server.service;

import com.boot.security.server.dto.OrderDTO;

public interface AiOrderFirstLevelService {

    boolean deleteOrder(Long id);

    String createOrder(OrderDTO orderDTO);

}
