package com.boot.security.server.api.order;

import com.boot.security.server.convert.OrderForm2OrderDTO;
import com.boot.security.server.dto.OrderDTO;
import com.boot.security.server.dto.OrderDetailDTO;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import com.boot.security.server.form.OrderForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 订单服务API
 * Created At 2018/11/14
 */
@RestController
@RequestMapping("/api/order")
public class OrderApiController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping
    public ResponseInfo create(@Valid OrderForm orderForm,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("订单参数异常，{}", bindingResult.getFieldError().getDefaultMessage());
            throw new SystemException(SystemStatusEnum.BIND_ERROR);
        }

        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        return new ResponseInfo<>(SystemStatusEnum.SUCCESS, orderDTO);
    }

    @GetMapping
    public List<OrderDetailDTO> get() {
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        OrderDetailDTO a = new OrderDetailDTO("123", 14);
        OrderDetailDTO b = new OrderDetailDTO("1234", 10);
        orderDetailDTOList.add(a);
        orderDetailDTOList.add(b);
        return orderDetailDTOList;
    }
}
