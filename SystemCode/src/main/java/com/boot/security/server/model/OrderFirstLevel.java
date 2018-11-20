package com.boot.security.server.model;

import java.util.Date;

public class OrderFirstLevel extends BaseEntity<Long> {

	private String serialnumber;
	private String usercode;
	private Date createtime;
	private String telephone;
	private Date paytime;
	private Date sendtime;
	private Date replytime;
	private Double orderpreprice;
	private Double orderrealprice;
	private String orderno;
	private Integer paystatus;
	private String failreason;
	private Integer paytype;
	private String payurl;
	private String ordercomment;
	private String datastate;

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
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

	public Double getOrderpreprice() {
		return orderpreprice;
	}

	public void setOrderpreprice(Double orderpreprice) {
		this.orderpreprice = orderpreprice;
	}

	public Double getOrderrealprice() {
		return orderrealprice;
	}

	public void setOrderrealprice(Double orderrealprice) {
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

	public String getDatastate() {
		return datastate;
	}

	public void setDatastate(String datastate) {
		this.datastate = datastate;
	}
}
