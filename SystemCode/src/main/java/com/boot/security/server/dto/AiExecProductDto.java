package com.boot.security.server.dto;

import com.boot.security.server.model.AiExecProduct;

/**
 * Created By Seven.wk
 * Description: AiExecProduct转换类
 * Created At 2018/09/27
 */
public class AiExecProductDto extends AiExecProduct {

    private String productType;     //分类名称

    private String creatorName;     //创建者名称

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
