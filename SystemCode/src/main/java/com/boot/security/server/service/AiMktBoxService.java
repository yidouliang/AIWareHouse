package com.boot.security.server.service;

import com.boot.security.server.model.AiMktBox;

import java.util.List;

public interface AiMktBoxService {

    /**
     * 获取运营商拥有的盒子的个数
     * @param operatorId
     * @return
     */
    int getBoxCountByOperatorId(Long operatorId);

    List<AiMktBox> getBoxListByOperatorId(Long operatorId);
}
