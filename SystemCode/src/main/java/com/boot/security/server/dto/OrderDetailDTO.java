package com.boot.security.server.dto;

import java.math.BigDecimal;

/**
 * Created By Seven.wk
 * Description: 订单详情传输模型
 * Created At 2018/11/14
 */
public class OrderDetailDTO {

    private String productCode;     // 产品编号

    private Integer quantity;       // 产品数量

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String productCode, Integer quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
