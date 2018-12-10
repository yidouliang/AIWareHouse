package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiOrderFirstLevelDao;
import com.boot.security.server.dao.AiOrderThirdLevelDao;
import com.boot.security.server.dto.OrderDTO;
import com.boot.security.server.dto.OrderDetailDTO;
import com.boot.security.server.dto.OrderInfoDTO;
import com.boot.security.server.dto.OrderInfoDetailDTO;
import com.boot.security.server.enums.PayStatusEnum;
import com.boot.security.server.model.AiOrderFirstLevel;
import com.boot.security.server.service.AiCupboardInventoryInstService;
import com.boot.security.server.service.AiExecProductService;
import com.boot.security.server.service.AiOrderFirstLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AiOrderFirstLevelServiceImpl implements AiOrderFirstLevelService {

    @Autowired
    private AiOrderFirstLevelDao aiOrderFirstLevelDao;

    @Autowired
    private AiOrderThirdLevelDao aiOrderThirdLevelDao;

    @Autowired
    private AiCupboardInventoryInstService aiCupboardInventoryInstService;

    @Override
    @Transactional
    public boolean deleteOrder(Long id) {

        //根据一级订单Id查询它的三级菜单
        List<Long> thirdOrderIdList = aiOrderThirdLevelDao.listThirdOrderByFirstOrderId(id);
        if(thirdOrderIdList!=null && thirdOrderIdList.size()>0){
            //更新所有三级订单的datastate为0
            aiOrderThirdLevelDao.deleteThirdOrder(thirdOrderIdList);
            return true;
        }
        //更新本一级订单的datastate为0
        aiOrderFirstLevelDao.deleteFirstOrder(id);
        return true;
    }

    @Override
    @Transactional
    public String createOrder(OrderDTO orderDTO) {
        AiOrderFirstLevel aiOrderFirstLevel = new AiOrderFirstLevel();

        // 从OrderDTO中读取信息
        String code = UUID.randomUUID().toString();
        aiOrderFirstLevel.setSerialnumber(code);
        aiOrderFirstLevel.setBoxcode(orderDTO.getBoxCode());
        aiOrderFirstLevel.setConsumerid(orderDTO.getConsumerId());

        // 设置默认信息
        aiOrderFirstLevel.setPaystatus(PayStatusEnum.WAIT.getCode());

        // 计算商品价格
        BigDecimal oldPrice = new BigDecimal(0);
        BigDecimal realPrice = new BigDecimal(0);
        for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetailDTOList()) {
            oldPrice = oldPrice.add(aiCupboardInventoryInstService
                    .getOriginPrice(orderDetailDTO.getProductCode(), Long.parseLong(orderDTO.getBoxCode()))
                    .multiply(BigDecimal.valueOf(orderDetailDTO.getQuantity())));
            realPrice = realPrice.add(aiCupboardInventoryInstService
                    .getSalePrice(orderDetailDTO.getProductCode(), Long.parseLong(orderDTO.getBoxCode()))
                    .multiply(BigDecimal.valueOf(orderDetailDTO.getQuantity())));
        }
        aiOrderFirstLevel.setOrderpreprice(oldPrice);
        aiOrderFirstLevel.setOrderrealprice(realPrice);

        // 信息入库
        aiOrderFirstLevelDao.save(aiOrderFirstLevel);

        return code;
    }

    @Override
    public List<OrderInfoDTO> getOrderInfo(String consumerId) {
        List<OrderInfoDTO> orderInfoDTOS = aiOrderFirstLevelDao.getOrderInfo(consumerId);
        if (orderInfoDTOS != null) {
            for (OrderInfoDTO orderInfoDTO : orderInfoDTOS) {
                List<OrderInfoDetailDTO> orderInfoDetailDTOS = aiOrderThirdLevelDao.getOrderInfoDetail(orderInfoDTO.getSerialNumber());
                orderInfoDTO.setOrderInfoDetailDTOS(orderInfoDetailDTOS);
            }
            return orderInfoDTOS;
        }
        return new ArrayList<>();
    }
}
