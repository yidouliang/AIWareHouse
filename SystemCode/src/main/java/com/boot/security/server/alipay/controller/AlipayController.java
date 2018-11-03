package com.boot.security.server.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.boot.security.server.alipay.constant.AlipayConstant;
import com.boot.security.server.alipay.service.AlipayService;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import com.boot.security.server.service.AiConsumerService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

    @Autowired
    private HttpSession httpSession;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/auth")
    @ApiOperation(value = "获取支付宝身份授权")
    public ResponseInfo auth(@RequestParam(value = "authCode") String authCode) throws AlipayApiException {
        if (StringUtils.isEmpty(authCode)) {
            throw new SystemException(SystemStatusEnum.BIND_ERROR);
        }

        if (httpSession.getAttribute(AlipayConstant.ALIPAY_UID) == null) {
            AlipaySystemOauthTokenResponse authResponse = alipayService.auth(authCode);
            AlipayUserInfoShareResponse alipayUserInfo = alipayService.getUserInfo(authResponse.getAccessToken());
            // 如果用户已存在，则不再添加新的用户信息
            if (!consumerService.isExists(alipayUserInfo.getUserId())) {
                consumerService.addFromAliPay(alipayUserInfo);
            }
            return new ResponseInfo<>(SystemStatusEnum.SUCCESS, alipayUserInfo.getUserId());
        } else {
            return new ResponseInfo<>(SystemStatusEnum.SUCCESS, httpSession.getAttribute(AlipayConstant.ALIPAY_UID));
        }
    }

}
