package com.boot.security.server.result;

/**
 * 用于封装支付报表数据
 */
public class PayCount {

    //使用某支付类型的数量
    private Integer value = 0;

    //支付类型
    private String name;


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
