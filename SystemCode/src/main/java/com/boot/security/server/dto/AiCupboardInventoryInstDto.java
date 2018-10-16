package com.boot.security.server.dto;

import com.boot.security.server.model.AiCupboardInventoryInst;

/**
 * Created By Seven.wk
 * Description: 转换模型
 * Created At 2018/10/16
 */
public class AiCupboardInventoryInstDto extends AiCupboardInventoryInst {
    private String warehouseName;       //仓库名称

    private String status;      //仓库状态名称

    private String creatorName;     //创建人名称

    private String operatorName;        //运营商名称

    private String boxName;     //盒子名称

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }
}
