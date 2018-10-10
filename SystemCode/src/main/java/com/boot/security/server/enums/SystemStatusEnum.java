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

    PRODUCT_NOT_EXIST("13", "商品不存在"),

    INVENTORY_SHORTAGE("14", "商品库存不足"),

    WAREHOUSE_NOT_EXIST("15", "仓库不存在"),

    BOX_NOT_EXIST("16", "盒子不存在"),

    BIND_ERROR("21","参数校验错误"),

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
