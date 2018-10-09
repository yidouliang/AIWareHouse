package com.boot.security.server.service;

import com.boot.security.server.model.AiOperator;

public interface AiOperatorService {

    AiOperator getAiOperatorByUserId(Long userId);

    AiOperator getAiOperatorById(Long operatorId);
}
