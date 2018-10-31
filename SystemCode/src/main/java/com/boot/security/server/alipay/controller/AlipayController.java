package com.boot.security.server.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.boot.security.server.alipay.service.AlipayService;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import com.boot.security.server.service.AiConsumerService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created By Seven.wk
 * Description: 支付宝相关业务接口
 * Created At 2018/10/31
 */
@RestController
@RequestMapping(value = "/api/alipay")
@CrossOrigin
public class AlipayController {

    @Autowired
    private AlipayService alipayService;

    @Autowired
    private AiConsumerService consumerService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/auth")
    public ResponseInfo auth(@RequestParam(value = "authCode") String authCode) throws AlipayApiException {
        if (StringUtils.isEmpty(authCode)) {
            throw new SystemException(SystemStatusEnum.BIND_ERROR);
        }

        // todo 先看session中有没有，再去认证平台获取，不然直接返回uid
        AlipaySystemOauthTokenResponse authResponse = alipayService.auth(authCode);

        AlipayUserInfoShareResponse alipayUserInfo = alipayService.getUserInfo(authResponse.getAccessToken());


//        consumerService.addFromAliPay(alipayUserInfo);

        return new ResponseInfo<>(SystemStatusEnum.SUCCESS, authResponse.getUserId());

    }
}
