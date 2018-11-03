package com.boot.security.server.service.impl;

import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.boot.security.server.dao.AiConsumerDao;
import com.boot.security.server.enums.ConsumerSourceEnum;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import com.boot.security.server.model.AiConsumer;
import com.boot.security.server.service.AiConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By Seven.wk
 * Description: 服务实现
 * Created At 2018/10/31
 */
@Service
public class AiConsumerServiceImpl implements AiConsumerService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AiConsumerDao aiConsumerDao;

    @Override
    public void addFromAliPay(AlipayUserInfoShareResponse alipayUserInfo) {
        AiConsumer consumer = new AiConsumer();
        consumer.setconsumerid(alipayUserInfo.getUserId());
        consumer.setName(alipayUserInfo.getNickName());
        // 消费者来源
        consumer.setSource(ConsumerSourceEnum.ALIPAY.getCode());
        // 消费者状态
        consumer.setState(1);
        // 消费者类型
        consumer.setType(0);
        aiConsumerDao.save(consumer);
        logger.info("用户ID：" + consumer.getconsumerid() + "，昵称：" + consumer.getName() + "注册成功");
    }

    @Override
    public boolean isExists(String uid) {
        return aiConsumerDao.countConsumerByConsumerId(uid) == 1;
    }

    @Override
    public AiConsumer getInfoByConsumerId(String consumerId) {
        AiConsumer aiConsumer = aiConsumerDao.getConsumerInfoByConsumerId(consumerId);
        if (aiConsumer == null) {
            throw new SystemException(SystemStatusEnum.CONSUMER_NOT_EXISTS);
        }
        return aiConsumer;
    }

}
