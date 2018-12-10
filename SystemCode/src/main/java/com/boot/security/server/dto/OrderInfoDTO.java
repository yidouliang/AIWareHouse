package com.boot.security.server.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 查询订单的订单传输模型
 * Created At 2018/11/22
 */
public class OrderInfoDTO {
    // 订单编号
    private String serialNumber;

    // 订单状态
    private String orderStatus;

    // 订单支付金额
    private BigDecimal payAmount;

    // 订单创建时间
    private Date createTime;

    // 盒子编号
    private Integer boxCode;

    // 支付时间
    private Date paytime;

    // 支付类型
    private String payType;

    // 订单详情
    private List<OrderInfoDetailDTO> orderInfoDetailDTOS;

    public OrderInfoDTO() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<OrderInfoDetailDTO> getOrderInfoDetailDTOS() {
        return orderInfoDetailDTOS;
    }

    public Integer getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(Integer boxCode) {
        this.boxCode = boxCode;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public void setOrderInfoDetailDTOS(List<OrderInfoDetailDTO> orderInfoDetailDTOS) {
        this.orderInfoDetailDTOS = orderInfoDetailDTOS;
    }

    @Override
    public String toString() {
        return "OrderInfoDTO{" +
                "serialNumber='" + serialNumber + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", payAmount=" + payAmount +
                ", createTime=" + createTime +
                ", boxCode=" + boxCode +
                ", paytime=" + paytime +
                ", payType='" + payType + '\'' +
                '}';
    }
}
