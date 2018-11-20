package com.boot.security.server.service;

import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.model.AiCupboardInventoryInst;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created By Seven.wk
 * Description: AiCupboardInventoryInst服务层
 * Created At 2018/10/08
 */
public interface AiCupboardInventoryInstService {

    ResponseInfo save(HttpServletRequest request, AiCupboardInventoryInst aiCupboardInventoryInst);

    ResponseInfo update(AiCupboardInventoryInst aiCupboardInventoryInst);

    BigDecimal getOriginPrice(String productCode, Long boxId);

    BigDecimal getSalePrice(String productCode, Long boxId);

    AiCupboardInventoryInst selectedByProductCodeAndBoxId(String productCode, Long boxId);

    void reduceInventory(Long id, Integer quantity);

}
