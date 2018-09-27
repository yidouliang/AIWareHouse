package com.boot.security.server.enums;

/**
 * Created By Seven.wk
 * Description: 数据状态枚举
 * Created At 2018/09/27
 */
public enum DataStatusEnum {
    DELETED(0, "已删除"),
    NORMAL(1, "正常"),
    ;
    int code;
    String message;

    DataStatusEnum(int code, String message) {
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
