package com.boot.security.server.enums;

/**
 * Created By Seven.wk
 * Description: 消费者来源
 * Created At 2018/11/03
 */
public enum ConsumerSourceEnum {
    WEIXIN(0, "微信"),
    ALIPAY(1, "支付宝"),

    ;

    int code;
    String message;

    ConsumerSourceEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
