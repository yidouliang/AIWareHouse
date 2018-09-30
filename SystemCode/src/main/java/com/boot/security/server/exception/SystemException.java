package com.boot.security.server.exception;

import com.boot.security.server.enums.SystemStatusEnum;

/**
 * Created By Seven.wk
 * Description: 自定义的系统异常
 * Created At 2018/09/30
 */
public class SystemException extends RuntimeException {
    String code;

    public SystemException(String code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(SystemStatusEnum systemStatusEnum) {
        super(systemStatusEnum.getMessage());
        this.code = systemStatusEnum.getCode();
    }

    public String getCode() {
        return code;
    }
}
