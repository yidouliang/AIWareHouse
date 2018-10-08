package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.dao.AiMktInventoryInstDao;
import com.boot.security.server.dao.AiWarehouseDao;
import com.boot.security.server.dao.AiWarehouseStockDao;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import com.boot.security.server.model.AiMktInventoryInst;
import com.boot.security.server.model.AiWarehouseStock;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.AiMktInventoryInstService;
import com.boot.security.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created By Seven.wk
 * Description: 服务层接口实现
 * Created At 2018/09/29
 */
@Service
public class AiMktInventoryInstServiceImpl implements AiMktInventoryInstService {

    @Autowired
    private UserService userService;

    @Autowired
    private AiWarehouseStockDao aiWarehouseStockDao;

    @Autowired
    private AiMktInventoryInstDao aiMktInventoryInstDao;

    @Override
    @Transactional
    public ResponseInfo save(HttpServletRequest request, AiMktInventoryInst aiMktInventoryInst) {
        //填充创建人信息
        SysUser user = userService.getTokenUser(request);
        aiMktInventoryInst.setCreateorgid(user.getId());

        //填充产品信息
        AiWarehouseStock aiWarehouseStock = aiWarehouseStockDao.getByProdinstidAndWarehouseid(aiMktInventoryInst.getProdinstid(), aiMktInventoryInst.getWarehouseid());
        if(aiWarehouseStock == null)
            throw new SystemException(SystemStatusEnum.PRODUCT_NOT_EXIST);
        aiMktInventoryInst.setProductcode(aiWarehouseStock.getProductcode());
        aiMktInventoryInst.setProductname(aiWarehouseStock.getProductname());
        aiMktInventoryInst.setOriginprice(aiWarehouseStock.getOldprice());
        aiMktInventoryInst.setFactorydate(aiWarehouseStock.getFactorydate());
        aiMktInventoryInst.setValidmonths(aiWarehouseStock.getValidmonths());
        aiMktInventoryInst.setBatchid(aiWarehouseStock.getBatchid());

        //计算售价
        aiMktInventoryInst.setSaleprice(aiWarehouseStock.getOldprice().multiply(aiMktInventoryInst.getDiscount()));

        //扣除仓库的库存
        Integer stock = aiWarehouseStock.getRemaindnum() - 1;
        if(stock < 0)
            throw new SystemException(SystemStatusEnum.INVENTORY_SHORTAGE);
        aiWarehouseStock.setRemaindnum(stock);
        aiWarehouseStockDao.update(aiWarehouseStock);

        aiMktInventoryInstDao.save(aiMktInventoryInst);

        return new ResponseInfo(SystemStatusEnum.SUCCESS);
    }

    @Override
    public ResponseInfo update(AiMktInventoryInst aiMktInventoryInst) {
        BigDecimal originPrice = aiMktInventoryInstDao.getOriginPrice(aiMktInventoryInst.getId());
        aiMktInventoryInst.setSaleprice(originPrice.multiply(aiMktInventoryInst.getDiscount()));
        aiMktInventoryInstDao.update(aiMktInventoryInst);
        return new ResponseInfo(SystemStatusEnum.SUCCESS);
    }
}
