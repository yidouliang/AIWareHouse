package com.boot.security.server.service;

import com.alipay.api.response.AlipayUserInfoShareResponse;

/**
 * Created By Seven.wk
 * Description: 消费者服务接口
 * Created At 2018/10/31
 */
public interface AiConsumerService {

    void addFromAliPay(AlipayUserInfoShareResponse alipayUserInfo);
}
