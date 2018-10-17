package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiOperatorDao;
import com.boot.security.server.model.AiOperator;
import com.boot.security.server.service.AiOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Override
    @Transactional
    public List<AiOperator> listAndUpdateOwnNum(Map<String, Object> params, Integer offset, Integer limit) {
        //更新运营商拥有的盒子数量为实际的数量
        //aiOperatorDao.updateOperatorOwnNum();
        return aiOperatorDao.list(params, offset, limit);
    }

    @Override
    public boolean updateOwnNumWithOperatorId(Long operatorId) {
        if(operatorId != null){
            return aiOperatorDao.incrOwnNum(operatorId);
        }
        return false;
    }

    @Override
    public boolean descOwnNum(Long operatorId) {
        if(operatorId != null){
            return aiOperatorDao.descOwnNum(operatorId);
        }
        return false;
    }


}
