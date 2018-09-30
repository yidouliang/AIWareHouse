package com.boot.security.server.enums;

/**
 * Created By Seven.wk
 * Description: 系统返回状态枚举
 * Created At 2018/09/30
 */
public enum SystemStatusEnum {
    SUCCESS("200", "成功"),

    IMPORT_EXCEL_SUCCESS("10", "Excel导入成功"),

    FILE_FORMAT_ERROR("11", "文件格式错误"),

    NO_NULL_VALUE("12", "表格中不能含有空值"),
    ;

    String code;
    String message;

    SystemStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
