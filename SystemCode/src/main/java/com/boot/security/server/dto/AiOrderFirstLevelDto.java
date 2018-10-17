package com.boot.security.server.dto;

import com.boot.security.server.model.AiOrderFirstLevel;
import com.boot.security.server.model.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class AiOrderFirstLevelDto extends AiOrderFirstLevel {

    //中文内容
    private String payStatusVal;

    private String payTypeVal;

    private String dataStateVal;

    public String getPayStatusVal() {
        return payStatusVal;
    }

    public void setPayStatusVal(String payStatusVal) {
        this.payStatusVal = payStatusVal;
    }

    public String getPayTypeVal() {
        return payTypeVal;
    }

    public void setPayTypeVal(String payTypeVal) {
        this.payTypeVal = payTypeVal;
    }

    public String getDataStateVal() {
        return dataStateVal;
    }

    public void setDataStateVal(String dataStateVal) {
        this.dataStateVal = dataStateVal;
    }
}
