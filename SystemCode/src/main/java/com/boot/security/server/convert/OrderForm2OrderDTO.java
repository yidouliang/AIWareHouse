package com.boot.security.server.convert;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boot.security.server.dto.OrderDTO;
import com.boot.security.server.dto.OrderDetailDTO;
import com.boot.security.server.form.OrderForm;

import java.util.List;

/**
 * Created By Seven.wk
 * Description: 将订单表单转换成OrderDTO
 * Created At 2018/11/14
 */
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setConsumerId(orderForm.getConsumerId());
        orderDTO.setBoxCode(orderForm.getBoxCode());

        List<OrderDetailDTO> orderDetailDTOList = JSONObject.parseArray(orderForm.getItems(), OrderDetailDTO.class);
        orderDTO.setOrderDetailDTOList(orderDetailDTOList);

        return orderDTO;
    }

}
