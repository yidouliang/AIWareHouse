package com.boot.security.server.dto;

import com.boot.security.server.model.AiMktBox;

public class AiMktBoxDto extends AiMktBox {

    private String boxTypeVal;

    private String statusVal;

    private String payStateVal;

    private String operatorName;

    private String wareHouseName;

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public String getBoxTypeVal() {
        return boxTypeVal;
    }

    public void setBoxTypeVal(String boxTypeVal) {
        this.boxTypeVal = boxTypeVal;
    }

    public String getStatusVal() {
        return statusVal;
    }

    public void setStatusVal(String statusVal) {
        this.statusVal = statusVal;
    }

    public String getPayStateVal() {
        return payStateVal;
    }

    public void setPayStateVal(String payStateVal) {
        this.payStateVal = payStateVal;
    }
}
