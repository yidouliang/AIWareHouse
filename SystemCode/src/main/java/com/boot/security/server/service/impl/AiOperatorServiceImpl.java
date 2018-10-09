package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiOperatorDao;
import com.boot.security.server.model.AiOperator;
import com.boot.security.server.service.AiOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiOperatorServiceImpl implements AiOperatorService {

    @Autowired
    private AiOperatorDao aiOperatorDao;

    @Override
    public AiOperator getAiOperatorByUserId(Long userId) {
        return aiOperatorDao.getAiOperatorByUserId(userId);
    }

    @Override
    public AiOperator getAiOperatorById(Long operatorId) {
        return aiOperatorDao.getById(operatorId);
    }
}
