package com.boot.security.server.service;

public interface AiMktBoxService {

    /**
     * 获取运营商拥有的盒子的个数
     * @param operatorId
     * @return
     */
    int getBoxCountByOperatorId(Long operatorId);
}
