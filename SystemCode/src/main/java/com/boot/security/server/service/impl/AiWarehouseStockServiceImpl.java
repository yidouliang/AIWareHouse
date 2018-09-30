package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.dao.AiWarehouseDao;
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
    private AiWarehouseDao aiWarehouseDao;

    @Override
    public AiWarehouseStock paddingField(HttpServletRequest request, AiWarehouseStock aiWarehouseStock) {
        //填充创建人
        SysUser user = userService.getTokenUser(request);
        aiWarehouseStock.setCreateorgid(user.getId());

        //填充商品相关信息
        AiExecProduct aiExecProduct = aiExecProductDao.getById(aiWarehouseStock.getProdinstid());
        aiWarehouseStock.setProductname(aiExecProduct.getProductname());
        aiWarehouseStock.setAicode(aiExecProduct.getAicode());
        aiWarehouseStock.setOldprice(aiExecProduct.getProductoriprice());
        aiWarehouseStock.setProductcode(aiExecProduct.getProductcode());

        //填充仓库相关信息
        AiWarehouse aiWarehouse = aiWarehouseDao.getById(aiWarehouseStock.getWarehouseid());
        aiWarehouseStock.setSupplier(aiWarehouse.getName());


        return aiWarehouseStock;
    }
}
