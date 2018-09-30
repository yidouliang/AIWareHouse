package com.boot.security.server.service;

import com.boot.security.server.model.AiMktInventoryInst;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Seven.wk
 * Description: AiMktInventoryInst服务接口
 * Created At 2018/09/29
 */
public interface AiMktInventoryInstService {

    AiMktInventoryInst paddingField(HttpServletRequest request, AiMktInventoryInst aiMktInventoryInst);
}
