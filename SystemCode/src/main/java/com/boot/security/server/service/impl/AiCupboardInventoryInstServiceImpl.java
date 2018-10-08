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

    @Override
    @Transactional
    public ResponseInfo save(HttpServletRequest request, AiCupboardInventoryInst aiCupboardInventoryInst) {

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

        //3.扣除仓库中商品的数量
        aiWarehouseStock.setRemaindnum(aiWarehouseStock.getRemaindnum() - aiCupboardInventoryInst.getAllnum());
        aiWarehouseStockDao.update(aiWarehouseStock);

        aiCupboardInventoryInstDao.save(aiCupboardInventoryInst);

        return new ResponseInfo(SystemStatusEnum.SUCCESS);
    }

    @Override
    public ResponseInfo update(AiCupboardInventoryInst aiCupboardInventoryInst) {
        //todo 此处的数量问题，暂时不清楚计算方式，应补充数量与库存的关系

        BigDecimal originPrice = aiCupboardInventoryInstDao.getOriginPrice(aiCupboardInventoryInst.getId());
        aiCupboardInventoryInst.setSaleprice(originPrice.multiply(aiCupboardInventoryInst.getDiscount()));
        aiCupboardInventoryInstDao.update(aiCupboardInventoryInst);
        return new ResponseInfo(SystemStatusEnum.SUCCESS);
    }
}
