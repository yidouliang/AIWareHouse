package com.boot.security.server.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.boot.security.server.alipay.constant.AlipayConstant;
import com.boot.security.server.alipay.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created By Seven.wk
 * Description: 服务实现
 * Created At 2018/10/31
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    @Autowired
    private HttpSession session;

    private static final String SERVER_URL = "https://openapi.alipay.com/gateway.do";

    private static final String APP_ID = "2018101861689797";

    private static final String FORMAT = "json";

    private static final String CHARSET = "GBK";

    private static final String SIGN_TYPE = "RSA2";

    private static final String PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCC+Mym9+iEoNaNhOMxuEwXpvJhKQ5PSUfVeuQ6zZFLlBM12D4G+oRsWfvXYY9u2OeOgi4n6Z69Wu82T7touX7MkTdRCW2ovzcWlntsub3Bd2AD3DbrlT5r2iHzK1BwLWAJEMH/yGEr0Tb5ggTn7mjyCUIWAD7wKtcy17lnU/yBIwuUMaaprdZpSGfyCK6BBfXVaaIy3mg1XEh3eWc7RY9n1T01RnBtMlbFB7CXIlDNBUFOdSoP/o+qgs0OM4/j9j6GC3BwF2yZhGrMeHLfUEWFiEgdxQ5d2bfrZAPL0xEI9UwQE8EVsnH1gN4W7P9UT9tDa56eaYxGKVFX7hCqH/O7AgMBAAECggEABUWah0YHV/9ZY4zr0D6I4ZLYwsxyRQLAH3m44h0QMiidtVck+AbxeaMNnhfRPDcC6xuWXAjtWNXmNxtygb6lufpGbb6haV95CjG4eiHn33e8p6sfktAJGTJIl48wx7Mr4HGKPY+FScw8GEMBi4xvMP7qaBROdEBlNSi1z9DzowcFHDL4KMtbR2Fk5QoYtFW0jL6c/ucWVySKe5g4W76QRDgYpiSPYITf2gFtKxw6axY8QP0Q/7eUe/0uCg5H/rOtXxtB1lHqWMkb8KWrbFqfGGaaBObu/GmELhjB8XnYPn17s7oF49Bc4J2raPMzc9720U63kEOToGdQeetB4FoaYQKBgQDcL/yqzxnUI7KbfPV4mSGvnZJKafxPxG9ixdcOxzLeBaFXVpOuUawM/If0YkQlLCYPBaxMWBVbd+uMEavKcQ1Fp7a2vYWeiqbR3TUkvPy1CkVDwiisW3WEachPy97KEDzbLU3j8G1yLXfgthV1ff/ZXtW+FjN5auDn5Cko1bYzwwKBgQCYRh2onRmIghMm3AnrVbRxdKvki1mINmt6WdbA4Bb2NVVkAL16xeh1wWNI3fnGxRpDPsITBCF4K3E1zblz1lBpwC/B4+Q6GJ9rWRPw+GZAB89M/o0PlgrdLOVCDGV08ANW9HYhrIXzdX7MNtwoTT8/x7Y0ee6pFNXQx9Wd67SYqQKBgQCJ6SSAd6bd0F4WNXYqSv9mV3NBWJDIBWkenHvOrcWWekBLy9ZD4LO6jpE46DN2dOiBkDQSvTjjSYEnAgpvic+eSSWP37TJUF6cI8kdcaF2YzBu+DUxfzdj8D2efTrVpMX5Ia8fjX9/fCsRe/qE1J5jL5sArDchXWfw1l9RTEoKsQKBgFR0LubhmtO3MOAQkf/P3PBAAUYUc2e0pw+I3C7FGncbRWzdbDm3oiINS/+R/YJctyAson7hf56imXt5yi2Q47CDQvmKZ35BQcnL8d9oJW3F5xeQ5rOKSCQ7Tju/nFWq+G81zn8GrJRGyjiBBMHldfrtzQR1zARC5gORkcywec1hAoGAGAS2wZryyS4ijM5jvVBplqoj5jKtMHzxElMeqDe1GhvF/06+pc9B2lp3DW5U7xCw95fdn6tLzt4qHVeNqjaWVvP/H1RXg7rUKLaQ5W+FtS9pTbGoGsktyLq53owUcEKIpU7T/rBJFdhJVAbQCdyk9CHE9uoRG3SwU/sxsQlZYIM=";

    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsfw2klKO1JIbKQnbi1dXIENNa2DDA3gANvc9hJT+ebrWa5eEetFtHe+Ij/cPpV1AUL3htDq1LUdk6Su8Q0UqQIBEQOon6gzggy6Uyq0uUe9MTrk59JyVvRCOW5IPLjYgdckJyaNfp7CXseGsZHuj18SxTrCBOQZ9mu5z8nlY1VB0tBMZS3jcyZfkFbfvK6Pa/27m/44DduVlo5p/dXCLZy+ytKDeKxXr8pk/ug9BA9vENa9epDSTVe+JPDi8iV4F9XyhrS8HkO730WXbP23WUmjAHzrmemODyCh+qoV0n0aw0EYuxajgGX9qo/D2vRUO/cjyHJ/Iq4PLPB1nj0l/UQIDAQAB";

    /**
     * 根据authCode，从支付宝认证平台获取uid和token
     * @param authCode
     * @return
     */
    @Override
    public AlipaySystemOauthTokenResponse auth(String authCode) throws AlipayApiException {

        AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL, APP_ID, PRIVATE_KEY, FORMAT, CHARSET, PUBLIC_KEY, SIGN_TYPE);
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("authorization_code");
        request.setCode(authCode);
        AlipaySystemOauthTokenResponse response = alipayClient.execute(request);

        if (response.isSuccess()) {
            session.setAttribute(AlipayConstant.ALIPAY_UID, response.getUserId());
            session.setAttribute(AlipayConstant.ALIPAY_TOKEN, response.getAccessToken());
            return response;
        } else {
            throw new AlipayApiException("支付宝身份认证失败");
        }
    }

    /**
     * 根据AccessToken到支付宝认证平台获取用户信息
     * @param accessToken
     * @return
     * @throws AlipayApiException
     */
    @Override
    public AlipayUserInfoShareResponse getUserInfo(String accessToken) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL, APP_ID, PRIVATE_KEY, FORMAT, CHARSET, PUBLIC_KEY, SIGN_TYPE);
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        AlipayUserInfoShareResponse alipayUserInfo = alipayClient.execute(request,accessToken);
        if(alipayUserInfo.isSuccess()){
            return alipayUserInfo;
        } else {
            throw new AlipayApiException("支付宝获取用户信息失败");
        }
    }
}
