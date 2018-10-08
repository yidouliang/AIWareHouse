package com.boot.security.server.service;

import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.model.AiCupboardInventoryInst;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Seven.wk
 * Description: AiCupboardInventoryInst服务层
 * Created At 2018/10/08
 */
public interface AiCupboardInventoryInstService {

    ResponseInfo save(HttpServletRequest request, AiCupboardInventoryInst aiCupboardInventoryInst);

    ResponseInfo update(AiCupboardInventoryInst aiCupboardInventoryInst);
}
