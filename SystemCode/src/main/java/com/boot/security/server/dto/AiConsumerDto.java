package com.boot.security.server.dto;

import com.boot.security.server.model.BaseEntity;

public class AiConsumerDto extends BaseEntity<Long> {

    private String name;
    private String telphone;
    private String type;
    private Integer starcode;
    private String source;
    private String descinfo;
    private String state;
    private String boxidreg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStarcode() {
        return starcode;
    }

    public void setStarcode(Integer starcode) {
        this.starcode = starcode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescinfo() {
        return descinfo;
    }

    public void setDescinfo(String descinfo) {
        this.descinfo = descinfo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBoxidreg() {
        return boxidreg;
    }

    public void setBoxidreg(String boxidreg) {
        this.boxidreg = boxidreg;
    }
}
