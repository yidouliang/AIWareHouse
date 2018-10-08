package com.boot.security.server.result;

/**
 * 支付类型与支付名称(中文)
 */
public class PayTypeAndValue {

    private Integer payType;
    private String payName;


    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }
}
