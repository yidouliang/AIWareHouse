package com.boot.security.server.enums;

/**
 * Created By Seven.wk
 * Description: 盒子状态枚举
 * Created At 2018/09/27
 */
public enum BoxStatusEnum {
    ABNORMAL(0, "运行异常"),
    NORMAL(1, "运行正常"),
    ARREARS(2, "盒子欠费")
    ;
    int code;
    String message;

    BoxStatusEnum (int code, String message) {
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
