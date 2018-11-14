package com.boot.security.server.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created By Seven.wk
 * Description: 用户订单表单
 * Created At 2018/11/14
 */
public class OrderForm {

    // 支付宝的userId
    @NotBlank(message = "用户ID不能为空")
    private String consumerId;

    // 购物车详情
    private String items;

    // 盒子id
    @NotBlank(message = "盒子ID不能为空")
    private String boxCode;

    public OrderForm() {}

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

}
