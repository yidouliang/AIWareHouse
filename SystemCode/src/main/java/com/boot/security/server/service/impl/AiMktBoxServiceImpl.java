package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiMktBoxDao;
import com.boot.security.server.service.AiMktBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiMktBoxServiceImpl implements AiMktBoxService {

    @Autowired
    private AiMktBoxDao aiMktBoxDao;

    @Override
    public int getBoxCountByOperatorId(Long operatorId) {
        return aiMktBoxDao.getBoxCountByOperatorId(operatorId);
    }
}
