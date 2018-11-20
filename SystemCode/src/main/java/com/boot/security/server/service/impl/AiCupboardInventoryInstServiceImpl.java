package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiCupboardInventoryInstDao;
import com.boot.security.server.dao.AiWarehouseStockDao;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import com.boot.security.server.model.AiCupboardInventoryInst;
import com.boot.security.server.model.AiWarehouseStock;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.AiCupboardInventoryInstService;
import com.boot.security.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.math.BigDecimal;

/**
 * Created By Seven.wk
 * Description: 实现层
 * Created At 2018/10/08
 */
@Service
public class AiCupboardInventoryInstServiceImpl implements AiCupboardInventoryInstService {

    @Autowired
    private AiWarehouseStockDao aiWarehouseStockDao;

    @Autowired
    private UserService userService;

    @Autowired
    private AiCupboardInventoryInstDao aiCupboardInventoryInstDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @Transactional
    public ResponseInfo save(HttpServletRequest request, AiCupboardInventoryInst aiCupboardInventoryInst) {

        if(aiCupboardInventoryInst.getBoxid() == null)
            throw new SystemException(SystemStatusEnum.BOX_NOT_EXIST);

        if(aiCupboardInventoryInst.getWarehouseid() == null)
            throw new SystemException(SystemStatusEnum.WAREHOUSE_NOT_EXIST);

        //1.从stock对象里获取对象并进行填充
        AiWarehouseStock aiWarehouseStock = aiWarehouseStockDao.getByProdinstidAndWarehouseid(aiCupboardInventoryInst.getProdinstid(), aiCupboardInventoryInst.getWarehouseid());
        if(aiWarehouseStock == null)
            throw new SystemException(SystemStatusEnum.PRODUCT_NOT_EXIST);

        if(aiCupboardInventoryInst.getAllnum() > aiWarehouseStock.getRemaindnum())
            throw new SystemException(SystemStatusEnum.INVENTORY_SHORTAGE);

        aiCupboardInventoryInst.setAicode(aiWarehouseStock.getAicode());
        aiCupboardInventoryInst.setBatchid(aiWarehouseStock.getBatchid());
        aiCupboardInventoryInst.setProductcode(aiWarehouseStock.getProductcode());
        aiCupboardInventoryInst.setProductname(aiWarehouseStock.getProductname());
        aiCupboardInventoryInst.setFactorydate(aiWarehouseStock.getFactorydate());
        aiCupboardInventoryInst.setValidmonths(aiWarehouseStock.getValidmonths());
        aiCupboardInventoryInst.setOriginprice(aiWarehouseStock.getOldprice());
        //初始时库存数量等于总数量
        aiCupboardInventoryInst.setRemindnum(aiCupboardInventoryInst.getAllnum());

        aiCupboardInventoryInst.setSaleprice(aiWarehouseStock.getOldprice().multiply(aiCupboardInventoryInst.getDiscount()));

        //2.设置创建者
        SysUser user = userService.getTokenUser(request);
        aiCupboardInventoryInst.setCreateoperid(user.getId());
        aiCupboardInventoryInst.setCreateorgid(user.getOperatorid());

        //3.扣除仓库中商品的数量
        aiWarehouseStock.setRemaindnum(aiWarehouseStock.getRemaindnum() - aiCupboardInventoryInst.getAllnum());
        aiWarehouseStockDao.update(aiWarehouseStock);

        aiCupboardInventoryInstDao.save(aiCupboardInventoryInst);

        return new ResponseInfo(SystemStatusEnum.SUCCESS);
    }

    @Override
    public ResponseInfo update(AiCupboardInventoryInst aiCupboardInventoryInst) {
        BigDecimal originPrice = aiCupboardInventoryInstDao.getOriginPrice(aiCupboardInventoryInst.getId());
        aiCupboardInventoryInst.setSaleprice(originPrice.multiply(aiCupboardInventoryInst.getDiscount()));
        aiCupboardInventoryInstDao.update(aiCupboardInventoryInst);
        return new ResponseInfo(SystemStatusEnum.SUCCESS);
    }

    @Override
    public BigDecimal getOriginPrice(String productCode, Long boxId) {
        BigDecimal originPrice = aiCupboardInventoryInstDao.getOriginPriceByProduct(productCode, boxId);
        if (originPrice == null) {
            logger.error("商品ID {} 不存在", productCode);
            throw new SystemException(SystemStatusEnum.PRODUCT_NOT_EXIST);
        }

        return originPrice;
    }

    @Override
    public BigDecimal getSalePrice(String productCode, Long boxId) {
        BigDecimal salePrice = aiCupboardInventoryInstDao.getSalePrice(productCode, boxId);
        if (salePrice == null) {
            logger.error("商品ID {} 不存在", productCode);
            throw new SystemException(SystemStatusEnum.PRODUCT_NOT_EXIST);
        }
        return salePrice;
    }

    @Override
    public AiCupboardInventoryInst selectedByProductCodeAndBoxId(String productCode, Long boxId) {
        // 根据商品编号和盒子编号找到商品信息
        AiCupboardInventoryInst product = aiCupboardInventoryInstDao.selectedByProductCodeAndBoxId(productCode, boxId);
        if (product == null) {
            logger.error("商品ID {} 不存在", productCode);
            throw new SystemException(SystemStatusEnum.PRODUCT_NOT_EXIST);
        }
        return product;
    }

    @Override
    public void reduceInventory(Long id, Integer quantity) {
        aiCupboardInventoryInstDao.reduceInventory(id, quantity);
    }
}
