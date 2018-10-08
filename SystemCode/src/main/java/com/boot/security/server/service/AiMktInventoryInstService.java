package com.boot.security.server.service;

import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.model.AiMktInventoryInst;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Seven.wk
 * Description: AiMktInventoryInst服务接口
 * Created At 2018/09/29
 */
public interface AiMktInventoryInstService {

    ResponseInfo save(HttpServletRequest request, AiMktInventoryInst aiMktInventoryInst);

    ResponseInfo update(AiMktInventoryInst aiMktInventoryInst);
}
