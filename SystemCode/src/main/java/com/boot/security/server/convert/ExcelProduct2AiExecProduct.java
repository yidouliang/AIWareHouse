package com.boot.security.server.convert;

import com.boot.security.server.dto.ExcelProduct;
import com.boot.security.server.model.AiExecProduct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 将ExcelProduct转换为ExecProduct
 * Created At 2018/09/20
 */
public class ExcelProduct2AiExecProduct {

    /**
     * 将ExcelProduct转换成ExecProduct类型
     * @param product
     * @return
     */
    public static AiExecProduct convert(ExcelProduct product) {
        AiExecProduct execProduct = new AiExecProduct();
        execProduct.setProductname(product.getProductName());
        execProduct.setProductcode(product.getProductCode());
        execProduct.setAicode(product.getAiCode());
        execProduct.setProductdesc(product.getProductDesc());
        execProduct.setProducttypeid(Long.parseLong(product.getProductTypeId().trim()));
        execProduct.setProductoriprice(new BigDecimal(product.getProductOriPrice().trim()));
        execProduct.setProductsource(product.getProductSource());
        return execProduct;
    }

    /**
     * 进行列表之间的转换
     * @param productList
     * @return
     */
    public static List<AiExecProduct> convert(List<ExcelProduct> productList) {
        List<AiExecProduct> execProductList = new ArrayList<>();
        for(ExcelProduct product : productList) {
            execProductList.add(convert(product));
        }
        return execProductList;
    }

}
