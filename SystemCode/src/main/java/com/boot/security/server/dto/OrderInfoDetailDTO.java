package com.boot.security.server.dto;

import java.math.BigDecimal;

/**
 * Created By Seven.wk
 * Description: 查询订单时的订单详情
 * Created At 2018/11/22
 */
public class OrderInfoDetailDTO {

    // 商品名称
    private String productName;

    // 商品数量
    private Integer buyNum;

    // 商品单价
    private BigDecimal productPrice;

    public OrderInfoDetailDTO() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getbuyNum() {
        return buyNum;
    }

    public void setbuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "OrderInfoDetailDTO{" +
                "productName='" + productName + '\'' +
                ", buyNum=" + buyNum +
                ", productPrice=" + productPrice +
                '}';
    }
}
