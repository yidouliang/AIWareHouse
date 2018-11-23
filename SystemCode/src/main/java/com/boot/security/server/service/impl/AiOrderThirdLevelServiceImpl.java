package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiOrderThirdLevelDao;
import com.boot.security.server.dto.OrderDTO;
import com.boot.security.server.dto.OrderDetailDTO;
import com.boot.security.server.dto.OrderInfoDetailDTO;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import com.boot.security.server.model.AiCupboardInventoryInst;
import com.boot.security.server.model.AiOrderThirdLevel;
import com.boot.security.server.service.AiCupboardInventoryInstService;
import com.boot.security.server.service.AiOrderThirdLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created By Seven.wk
 * Description: 服务实现
 * Created At 2018/11/15
 */
@Service
public class AiOrderThirdLevelServiceImpl implements AiOrderThirdLevelService {

    @Autowired
    private AiOrderThirdLevelDao aiOrderThirdLevelDao;

    @Autowired
    private AiCupboardInventoryInstService aiCupboardInventoryInstService;

    @Override
    @Transactional
    public void createThirdOrder(String orderCode, OrderDTO orderDTO) {

        for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetailDTOList()) {
            AiOrderThirdLevel aiOrderThirdLevel = new AiOrderThirdLevel();

            aiOrderThirdLevel.setSerialnumber(UUID.randomUUID().toString());
            aiOrderThirdLevel.setFirstlevelid(orderCode);
            aiOrderThirdLevel.setUsercode(orderDTO.getConsumerId());
            aiOrderThirdLevel.setBoxname(orderDTO.getBoxCode());

            // 设置产品详细信息
            AiCupboardInventoryInst product = aiCupboardInventoryInstService.selectedByProductCodeAndBoxId(orderDetailDTO.getProductCode(), Long.parseLong(orderDTO.getBoxCode()));
            aiOrderThirdLevel.setBuynum(orderDetailDTO.getQuantity());
            aiOrderThirdLevel.setProductname(product.getProductname());
            aiOrderThirdLevel.setProductprice(product.getSaleprice());

            // 扣库存
            aiCupboardInventoryInstService.reduceInventory(product.getId(), (product.getRemindnum() - orderDetailDTO.getQuantity()));

            // 将三级订单入库
            aiOrderThirdLevelDao.save(aiOrderThirdLevel);
        }
    }

    @Override
    public List<OrderInfoDetailDTO> getOrderInfoDetail(String firstLevelId) {
        List<OrderInfoDetailDTO> orderInfoDetailDTOS = aiOrderThirdLevelDao.getOrderInfoDetail(firstLevelId);
        if (orderInfoDetailDTOS == null) {
            throw new SystemException(SystemStatusEnum.ORDER_INFO_LOST);
        }
        return orderInfoDetailDTOS;
    }
}
