package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiOrderFirstLevelDao;
import com.boot.security.server.dao.AiOrderThirdLevelDao;
import com.boot.security.server.service.AiOrderFirstLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AiOrderFirstLevelServiceImpl implements AiOrderFirstLevelService {

    @Autowired
    private AiOrderFirstLevelDao aiOrderFirstLevelDao;

    @Autowired
    private AiOrderThirdLevelDao aiOrderThirdLevelDao;

    @Override
    @Transactional
    public boolean deleteOrder(Long id) {

        //根据一级订单Id查询它的三级菜单
        List<Long> thirdOrderIdList = aiOrderThirdLevelDao.listThirdOrderByFirstOrderId(id);
        if(thirdOrderIdList!=null && thirdOrderIdList.size()>0){
            //更新所有三级订单的datastate为0
            aiOrderThirdLevelDao.deleteThirdOrder(thirdOrderIdList);
            return true;
        }
        //更新本一级订单的datastate为0
        aiOrderFirstLevelDao.deleteFirstOrder(id);
        return true;
    }
}
