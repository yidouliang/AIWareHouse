package com.boot.security.server.enums;

/**
 * Created By Seven.wk
 * Description: 产品状态枚举
 * Created At 2018/09/27
 */
public enum ProductStatusEnum {

    OBTAINED(0, "下架"),
    IN_STOCK(1, "在售"),
            ;

    int code;
    String message;

    ProductStatusEnum (int code, String message) {
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
