package com.boot.security.server.dto;

import com.boot.security.server.model.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class AiOrderFirstLevelDto extends BaseEntity<Long> {

    private String serialnumber;
    private Long consumerid;
    private Date createtime;
    private String telephone;
    private Long boxcode;
    private Date paytime;
    private Date sendtime;
    private Date replytime;
    private BigDecimal orderpreprice;
    private BigDecimal orderrealprice;
    private String orderno;
    //支付状态 11,待支付，100.成功，107.删除，108.失效，109.失败
    private String paystatus;
    private String failreason;
    //支付方式：AiConsumerSource 0 微信 1 支付宝 3 建设银行...
    private String paytype;
    private String payurl;
    private String ordercomment;
    //数据状态 0 无效 1 有效
    private String datastate;

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Long getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(Long consumerid) {
        this.consumerid = consumerid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getBoxcode() {
        return boxcode;
    }

    public void setBoxcode(Long boxcode) {
        this.boxcode = boxcode;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public BigDecimal getOrderpreprice() {
        return orderpreprice;
    }

    public void setOrderpreprice(BigDecimal orderpreprice) {
        this.orderpreprice = orderpreprice;
    }

    public BigDecimal getOrderrealprice() {
        return orderrealprice;
    }

    public void setOrderrealprice(BigDecimal orderrealprice) {
        this.orderrealprice = orderrealprice;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus;
    }

    public String getFailreason() {
        return failreason;
    }

    public void setFailreason(String failreason) {
        this.failreason = failreason;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPayurl() {
        return payurl;
    }

    public void setPayurl(String payurl) {
        this.payurl = payurl;
    }

    public String getOrdercomment() {
        return ordercomment;
    }

    public void setOrdercomment(String ordercomment) {
        this.ordercomment = ordercomment;
    }

    public String getDatastate() {
        return datastate;
    }

    public void setDatastate(String datastate) {
        this.datastate = datastate;
    }
}
