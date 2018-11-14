package com.boot.security.server.dto;

import java.util.List;

/**
 * Created By Seven.wk
 * Description: 订单传输模型
 * Created At 2018/11/14
 */
public class OrderDTO {

    private String consumerId;

    private String boxCode;

    private List<OrderDetailDTO> orderDetailDTOList;

    public OrderDTO() {
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public List<OrderDetailDTO> getOrderDetailDTOList() {
        return orderDetailDTOList;
    }

    public void setOrderDetailDTOList(List<OrderDetailDTO> orderDetailDTOList) {
        this.orderDetailDTOList = orderDetailDTOList;
    }
}
