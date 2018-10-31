package com.boot.security.server.service.impl;

import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.boot.security.server.dao.AiConsumerDao;
import com.boot.security.server.model.AiConsumer;
import com.boot.security.server.service.AiConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By Seven.wk
 * Description: 服务实现
 * Created At 2018/10/31
 */
@Service
public class AiConsumerServiceImpl implements AiConsumerService {

    @Autowired
    private AiConsumerDao aiConsumerDao;

    @Override
    public void addFromAliPay(AlipayUserInfoShareResponse alipayUserInfo) {
        AiConsumer consumer = new AiConsumer();
        consumer.setconsumerid(alipayUserInfo.getUserId());
        consumer.setName(alipayUserInfo.getNickName());
        consumer.setSource(0);
        consumer.setState(1);
        aiConsumerDao.save(consumer);
    }
}
