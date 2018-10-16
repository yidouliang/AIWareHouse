package com.boot.security.server.dto;

import com.boot.security.server.model.AiWarehouse;

/**
 * Created By Seven.wk
 * Description: AIWarehouse的传递模型
 * Created At 2018/10/16
 */
public class AiWarehouseDto extends AiWarehouse {
    public String typeName;         //仓库类型名称

    public String operatorName;     //仓库运营商名称

    public String stateName;       //仓库状态

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "AiWarehouseDto{" +
                "typeName='" + typeName + '\'' +
                ", operatorName='" + operatorName + '\'' +
                '}';
    }
}
