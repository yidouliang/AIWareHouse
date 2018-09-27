package com.boot.security.server.dto;

import com.boot.security.server.model.AiMktBox;

public class AiMktBoxVo extends AiMktBox {

    //地区信息 省/市/区(县)
    private String area;

    //用于显示的中文(货柜类型)
    private String AiBoxType;

    //用于显示的中文（货柜状态）
    private String AiBoxStatus;

    //用于显示的中文（支付状态）
    private String payState;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAiBoxType() {
        return AiBoxType;
    }

    public void setAiBoxType(String aiBoxType) {
        AiBoxType = aiBoxType;
    }

    public String getAiBoxStatus() {
        return AiBoxStatus;
    }

    public void setAiBoxStatus(String aiBoxStatus) {
        AiBoxStatus = aiBoxStatus;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }
}
