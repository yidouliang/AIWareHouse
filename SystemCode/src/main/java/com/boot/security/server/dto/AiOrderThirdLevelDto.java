package com.boot.security.server.dto;

import com.boot.security.server.model.AiOrderThirdLevel;
import com.boot.security.server.model.BaseEntity;

import java.math.BigDecimal;

public class AiOrderThirdLevelDto extends AiOrderThirdLevel {

    private String boxTypeVal;

    private String productTypeVal;

    private String dataStateVal;

    public String getBoxTypeVal() {
        return boxTypeVal;
    }

    public void setBoxTypeVal(String boxTypeVal) {
        this.boxTypeVal = boxTypeVal;
    }

    public String getProductTypeVal() {
        return productTypeVal;
    }

    public void setProductTypeVal(String productTypeVal) {
        this.productTypeVal = productTypeVal;
    }

    public String getDataStateVal() {
        return dataStateVal;
    }

    public void setDataStateVal(String dataStateVal) {
        this.dataStateVal = dataStateVal;
    }
}
