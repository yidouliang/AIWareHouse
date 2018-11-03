package com.boot.security.server.service;

import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.boot.security.server.model.AiConsumer;

/**
 * Created By Seven.wk
 * Description: 消费者服务接口
 * Created At 2018/10/31
 */
public interface AiConsumerService {

    void addFromAliPay(AlipayUserInfoShareResponse alipayUserInfo);

    boolean isExists(String uid);

    AiConsumer getInfoByConsumerId(String consumerId);

}
