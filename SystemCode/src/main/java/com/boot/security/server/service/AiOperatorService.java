package com.boot.security.server.service;

import com.boot.security.server.model.AiOperator;

import java.util.List;
import java.util.Map;

public interface AiOperatorService {

    AiOperator getAiOperatorByUserId(Long userId);

    AiOperator getAiOperatorById(Long operatorId);

    List<AiOperator> listAndUpdateOwnNum(Map<String, Object> params,Integer offset,Integer limit);

    boolean updateOwnNumWithOperatorId(Long operatorId);

    boolean descOwnNum(Long operatorId);
}
