package com.boot.security.server.dto;

import com.boot.security.server.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class AiMktBoxVo extends BaseEntity<Long> {

    private String boxname;
    private String boxcode;
    private String boxtype;
    private Long boxperson;
    private String address;
    private String status;
    private Date factorydate;
    private String paystate;
    private Integer boxwarehouseid;
    private Date enddate;
    private String persontelphone;
    private BigDecimal longitude;
    private BigDecimal latitude;

    //地区信息 省/市/区(县)
    private String area;


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBoxname() {
        return boxname;
    }

    public void setBoxname(String boxname) {
        this.boxname = boxname;
    }

    public String getBoxcode() {
        return boxcode;
    }

    public void setBoxcode(String boxcode) {
        this.boxcode = boxcode;
    }

    public String getBoxtype() {
        return boxtype;
    }

    public void setBoxtype(String boxtype) {
        this.boxtype = boxtype;
    }

    public Long getBoxperson() {
        return boxperson;
    }

    public void setBoxperson(Long boxperson) {
        this.boxperson = boxperson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFactorydate() {
        return factorydate;
    }

    public void setFactorydate(Date factorydate) {
        this.factorydate = factorydate;
    }

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }

    public Integer getBoxwarehouseid() {
        return boxwarehouseid;
    }

    public void setBoxwarehouseid(Integer boxwarehouseid) {
        this.boxwarehouseid = boxwarehouseid;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getPersontelphone() {
        return persontelphone;
    }

    public void setPersontelphone(String persontelphone) {
        this.persontelphone = persontelphone;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
