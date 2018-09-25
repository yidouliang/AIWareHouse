package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiOrderFirstLevel extends BaseEntity<Long> {

	private String serialnumber;
	private String consumerid;
	private Date createtime;
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
	private String datastate;
	private String ext1;
	private String ext2;
	private String ext3;

	public String getSerialnumber() {
		return serialnumber;
	}
	public String setSerialnumber() {
		return serialnumber;
	}
	public String getConsumerid() {
		return consumerid;
	}
	public String setConsumerid() {
		return consumerid;
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
	public String getBoxcode() {
		return boxcode;
	}
	public String setBoxcode() {
		return boxcode;
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
	public BigDecimal getOrderpreprice() {
		return orderpreprice;
	}
	public BigDecimal setOrderpreprice() {
		return orderpreprice;
	}
	public BigDecimal getOrderrealprice() {
		return orderrealprice;
	}
	public BigDecimal setOrderrealprice() {
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
	public String getExt1() {
		return ext1;
	}
	public String setExt1() {
		return ext1;
	}
	public String getExt2() {
		return ext2;
	}
	public String setExt2() {
		return ext2;
	}
	public String getExt3() {
		return ext3;
	}
	public String setExt3() {
		return ext3;
	}

}
