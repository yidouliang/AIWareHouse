package com.boot.security.server.form;

import com.boot.security.server.model.BaseEntity;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class AiOperatorForm extends BaseEntity<Long> {

    @NotNull
    private String name;
    private String description;
    @Range(max=5, min=0,message = "星级只能为数字,且范围为0-5")
    private Integer level;
    @DecimalMin(value = "0",message = "参数不合法")
    private Integer owernum;
    private Integer userid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOwernum() {
        return owernum;
    }

    public void setOwernum(Integer owernum) {
        this.owernum = owernum;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
