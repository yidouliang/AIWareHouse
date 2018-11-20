package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiOrderFirstLevel extends BaseEntity<Long> {

	private String serialnumber;
	private String consumerid;
	private String telephone;
	private String boxcode;
	private Date paytime;
	private Date sendtime;
	private Date replytime;
	private BigDecimal orderpreprice;
	private BigDecimal orderrealprice;
	private String orderno;
	private Integer paystatus;
	private String failreason;
	private Integer paytype;
	private String payurl;
	private String ordercomment;
	private Integer datastate;
    private Date createtime = new Date();
	private String ext1;
	private String ext2;
	private String ext3;


	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getConsumerid() {
		return consumerid;
	}

	public void setConsumerid(String consumerid) {
		this.consumerid = consumerid;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBoxcode() {
		return boxcode;
	}

	public void setBoxcode(String boxcode) {
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

	public Integer getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}

	public String getFailreason() {
		return failreason;
	}

	public void setFailreason(String failreason) {
		this.failreason = failreason;
	}

	public Integer getPaytype() {
		return paytype;
	}

	public void setPaytype(Integer paytype) {
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

	public Integer getDatastate() {
		return datastate;
	}

	public void setDatastate(Integer datastate) {
		this.datastate = datastate;
	}

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
