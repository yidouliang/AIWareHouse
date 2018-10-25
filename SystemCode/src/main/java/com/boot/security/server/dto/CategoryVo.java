package com.boot.security.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CategoryVo {

    private String msg;

    private Integer code;

    private List<CategoryDto> data;

    private Integer count;

    @JsonProperty("is")
    private boolean status = true;

    private String tip;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<CategoryDto> getData() {
        return data;
    }

    public void setData(List<CategoryDto> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
