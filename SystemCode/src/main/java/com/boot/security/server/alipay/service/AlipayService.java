package com.boot.security.server.alipay.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;

/**
 * Created By Seven.wk
 * Description: 支付宝服务接口
 * Created At 2018/10/31
 */
public interface AlipayService {

    AlipaySystemOauthTokenResponse auth(String authCode) throws AlipayApiException;

    AlipayUserInfoShareResponse getUserInfo(String accessToken) throws AlipayApiException;

}
