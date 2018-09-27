package com.boot.security.server.enums;

/**
 * Created By Seven.wk
 * Description: 支付状态枚举类
 * Created At 2018/09/27
 */
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    FAIL(2, "支付失败")
    ;

    int code ;
    String message;

    PayStatusEnum(int code, String message) {
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
