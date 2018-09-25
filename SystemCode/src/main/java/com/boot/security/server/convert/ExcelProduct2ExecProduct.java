package com.boot.security.server.convert;

import com.boot.security.server.dto.ExcelProduct;
import com.boot.security.server.model.ExecProduct;
import com.boot.security.server.utils.StrUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 将ExcelProduct转换为ExecProduct
 * Created At 2018/09/20
 */
public class ExcelProduct2ExecProduct {

    /**
     * 将ExcelProduct转换成ExecProduct类型
     * @param product
     * @return
     */
    public static ExecProduct convert(ExcelProduct product) {
        ExecProduct execProduct = new ExecProduct();
        execProduct.setProductName(product.getProductName());
        execProduct.setProductCode(product.getProductCode());
        execProduct.setProductDesc(product.getProductDesc());
        execProduct.setProductTypeId(new BigDecimal(product.getProductTypeId()));
        execProduct.setProductStartTime(StrUtil.str2Date(product.getProductStartTime()));
        execProduct.setProductEndTime(StrUtil.str2Date(product.getProductEndTime()));
        execProduct.setCompany(product.getCompany());
        execProduct.setProductPrice(new BigDecimal(product.getProductPrice()));
        execProduct.setProductOriPrice(new BigDecimal(product.getProductOriPrice()));
        execProduct.setProductSource(execProduct.getProductSource());
        return execProduct;
    }

    /**
     * 进行列表之间的转换
     * @param productList
     * @return
     */
    public static List<ExecProduct> convert(List<ExcelProduct> productList) {
        List<ExecProduct> execProductList = new ArrayList<>();
        for(ExcelProduct product : productList) {
            execProductList.add(convert(product));
        }
        return execProductList;
    }

}
