package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.dao.AiWarehouseDao;
import com.boot.security.server.dao.AiWarehouseStockDao;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import com.boot.security.server.model.AiExecProduct;
import com.boot.security.server.model.AiWarehouse;
import com.boot.security.server.model.AiWarehouseStock;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.AiWarehouseStockService;
import com.boot.security.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Seven.wk
 * Description: 服务接口实现
 * Created At 2018/09/28
 */
@Service
public class AiWarehouseStockServiceImpl implements AiWarehouseStockService {

    @Autowired
    private UserService userService;

    @Autowired
    private AiExecProductDao aiExecProductDao;

    @Autowired
    private AiWarehouseStockDao aiWarehouseStockDao;

    @Override
    public ResponseInfo save(HttpServletRequest request, AiWarehouseStock aiWarehouseStock) {

        if(aiWarehouseStock.getWarehouseid() == null)
            throw new SystemException(SystemStatusEnum.WAREHOUSE_NOT_EXIST);

        //填充创建人和运营商
        SysUser user = userService.getTokenUser(request);
        aiWarehouseStock.setCreateoperid(user.getId());
        aiWarehouseStock.setCreateorgid(user.getOperatorid());

        //填充商品相关信息
        AiExecProduct aiExecProduct = aiExecProductDao.getById(aiWarehouseStock.getProdinstid());
        aiWarehouseStock.setProductname(aiExecProduct.getProductname());
        aiWarehouseStock.setAicode(aiExecProduct.getAicode());
        aiWarehouseStock.setOldprice(aiExecProduct.getProductoriprice());
        aiWarehouseStock.setProductcode(aiExecProduct.getProductcode());
        aiWarehouseStock.setRemaindnum(aiWarehouseStock.getAllnum());       //初始数量与总数量相同

        aiWarehouseStockDao.save(aiWarehouseStock);

        return new ResponseInfo(SystemStatusEnum.SUCCESS);
    }
}
