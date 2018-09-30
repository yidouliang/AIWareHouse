package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.dao.AiWarehouseDao;
import com.boot.security.server.dao.AiWarehouseStockDao;
import com.boot.security.server.model.*;
import com.boot.security.server.service.AiMktInventoryInstService;
import com.boot.security.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

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
    private AiExecProductDao aiExecProductDao;

    @Autowired
    private AiWarehouseStockDao aiWarehouseStockDao;

    @Autowired
    private AiWarehouseDao aiWarehouseDao;

    @Override
    public AiMktInventoryInst paddingField(HttpServletRequest request, AiMktInventoryInst aiMktInventoryInst) {
        //填充创建人信息
        SysUser user = userService.getTokenUser(request);
        aiMktInventoryInst.setCreateorgid(user.getId());

        //填充产品信息
        //todo aiMktInventoryInst里少了warehouseid字段，无法查找对应的仓库
        //AiWarehouseStock aiWarehouseStock = aiWarehouseStockDao.getByProdinstidAndWarehouseid(aiMktInventoryInst.getProdinstid(), aiMktInventoryInst);
//        AiExecProduct aiExecProduct = aiExecProductDao.getById(aiMktInventoryInst.getProdinstid());
//        aiMktInventoryInst.setProductname(aiExecProduct.getProductname());
//        aiMktInventoryInst.setProductcode(aiExecProduct.getProductcode());
//        aiMktInventoryInst.setSerialno(Long.parseLong(aiExecProduct.getAicode()));
//        aiMktInventoryInst.setSaleprice(aiExecProduct.getProductoriprice().multiply(aiMktInventoryInst.getDiscount()));
//        aiMktInventoryInst.setFactorydate();
//        AiWarehouseStock aiWarehouseStock = aiWarehouseStockDao.getById()

        //填充仓库信息，并且扣除仓库的库存
        AiWarehouse aiWarehouse = aiWarehouseDao.getById((long) aiMktInventoryInst.getBoxid());
        aiMktInventoryInst.setWarehouseid(aiWarehouse.getId());

        //填充盒子的信息

        return aiMktInventoryInst;
    }
}
