package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiMktBoxDao;
import com.boot.security.server.model.AiMktBox;
import com.boot.security.server.service.AiMktBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiMktBoxServiceImpl implements AiMktBoxService {

    @Autowired
    private AiMktBoxDao aiMktBoxDao;

    @Override
    public int getBoxCountByOperatorId(Long operatorId) {
        return aiMktBoxDao.getBoxCountByOperatorId(operatorId);
    }

    @Override
    public List<AiMktBox> getBoxListByOperatorId(Long operatorId) {
        return aiMktBoxDao.getBoxListByOperatorId(operatorId);
    }
}
