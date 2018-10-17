package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiMktBoxDao;
import com.boot.security.server.model.AiMktBox;
import com.boot.security.server.model.AiOperator;
import com.boot.security.server.service.AiMktBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AiMktBoxServiceImpl implements AiMktBoxService {

    @Autowired
    private AiMktBoxDao aiMktBoxDao;

    @Autowired
    private AiOperatorServiceImpl aiOperatorService;

    @Override
    public int getBoxCountByOperatorId(Long operatorId) {
        return aiMktBoxDao.getBoxCountByOperatorId(operatorId);
    }

    @Override
    public List<AiMktBox> getBoxListByOperatorId(Long operatorId) {
        return aiMktBoxDao.getBoxListByOperatorId(operatorId);
    }

    @Override
    @Transactional
    public int addBox(AiMktBox aiMktBox,Long operatorId) {
        aiOperatorService.updateOwnNumWithOperatorId(operatorId);
        return aiMktBoxDao.save(aiMktBox);
    }

    @Override
    @Transactional
    public boolean removeBox(Long boxId) {
        //通过boxId查询AiBox
        AiMktBox aiMktBox = aiMktBoxDao.getById(boxId);
        //根据AiBox的boxperson查询operator
        AiOperator aiOperator = aiOperatorService.getAiOperatorById(aiMktBox.getBoxperson());
        //先获取operator的盒子数量,判断是否大于0,减少operator的owerNum
        Long operatorId = aiOperator.getId();
        int count = getBoxCountByOperatorId(operatorId);
        if(count<=0){
            return false;
        }
        aiOperatorService.descOwnNum(operatorId);
        //删除Aibox
        aiMktBoxDao.delete(boxId);
        return true;
    }

    //每一天检查一次盒子是否过期,如果过期就更新状态(最低购买日期一个月)
    @Scheduled(initialDelay = 50000,fixedRate = 92256000)
    @Transactional
    public void isArrears(){
        //获取所有过期的且缴费状态为已缴费的盒子
        List<Long> boxIdList = aiMktBoxDao.getExpireAiMktBoxList();
        //更新过期盒子的状态为过期
        if(boxIdList!=null && boxIdList.size()>0){
            aiMktBoxDao.changePayStateByScheduled(boxIdList);
        }
    }
}
