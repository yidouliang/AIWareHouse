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
	public String setSerialnumber() {
		return serialnumber;
	}
	public String getUsercode() {
		return usercode;
	}
	public String setUsercode() {
		return usercode;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public Date setCreatetime() {
		return createtime;
	}
	public String getTelephone() {
		return telephone;
	}
	public String setTelephone() {
		return telephone;
	}
	public Date getPaytime() {
		return paytime;
	}
	public Date setPaytime() {
		return paytime;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public Date setSendtime() {
		return sendtime;
	}
	public Date getReplytime() {
		return replytime;
	}
	public Date setReplytime() {
		return replytime;
	}
	public Double getOrderpreprice() {
		return orderpreprice;
	}
	public Double setOrderpreprice() {
		return orderpreprice;
	}
	public Double getOrderrealprice() {
		return orderrealprice;
	}
	public Double setOrderrealprice() {
		return orderrealprice;
	}
	public String getOrderno() {
		return orderno;
	}
	public String setOrderno() {
		return orderno;
	}
	public Integer getPaystatus() {
		return paystatus;
	}
	public Integer setPaystatus() {
		return paystatus;
	}
	public String getFailreason() {
		return failreason;
	}
	public String setFailreason() {
		return failreason;
	}
	public Integer getPaytype() {
		return paytype;
	}
	public Integer setPaytype() {
		return paytype;
	}
	public String getPayurl() {
		return payurl;
	}
	public String setPayurl() {
		return payurl;
	}
	public String getOrdercomment() {
		return ordercomment;
	}
	public String setOrdercomment() {
		return ordercomment;
	}
	public String getDatastate() {
		return datastate;
	}
	public String setDatastate() {
		return datastate;
	}

}
