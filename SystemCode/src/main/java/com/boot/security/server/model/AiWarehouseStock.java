package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiWarehouseStock extends BaseEntity<Long> {

	private BigDecimal prodinstid;
	private String productname;
	private String serialno;
	private Integer allnum;
	private Integer remaindnum;
	private String aicode;
	private Integer userid;
	private BigDecimal oldprice;
	private BigDecimal nowprice;
	private Integer warehouseid;
	private BigDecimal discount;
	private String batchid;
	private String supplier;
	private Date factorydate;
	private Date validmonths;
	private String storestatus;
	private String statusstatereason;
	private String createoperid;
	private String createorgid;
	private Date createdate;
	private Date modifydate;
	private String datastate;
	private String ext1;
	private String ext2;
	private String ext3;

	public BigDecimal getProdinstid() {
		return prodinstid;
	}
	public BigDecimal setProdinstid() {
		return prodinstid;
	}
	public String getProductname() {
		return productname;
	}
	public String setProductname() {
		return productname;
	}
	public String getSerialno() {
		return serialno;
	}
	public String setSerialno() {
		return serialno;
	}
	public Integer getAllnum() {
		return allnum;
	}
	public Integer setAllnum() {
		return allnum;
	}
	public Integer getRemaindnum() {
		return remaindnum;
	}
	public Integer setRemaindnum() {
		return remaindnum;
	}
	public String getAicode() {
		return aicode;
	}
	public String setAicode() {
		return aicode;
	}
	public Integer getUserid() {
		return userid;
	}
	public Integer setUserid() {
		return userid;
	}
	public BigDecimal getOldprice() {
		return oldprice;
	}
	public BigDecimal setOldprice() {
		return oldprice;
	}
	public BigDecimal getNowprice() {
		return nowprice;
	}
	public BigDecimal setNowprice() {
		return nowprice;
	}
	public Integer getWarehouseid() {
		return warehouseid;
	}
	public Integer setWarehouseid() {
		return warehouseid;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public BigDecimal setDiscount() {
		return discount;
	}
	public String getBatchid() {
		return batchid;
	}
	public String setBatchid() {
		return batchid;
	}
	public String getSupplier() {
		return supplier;
	}
	public String setSupplier() {
		return supplier;
	}
	public Date getFactorydate() {
		return factorydate;
	}
	public Date setFactorydate() {
		return factorydate;
	}
	public Date getValidmonths() {
		return validmonths;
	}
	public Date setValidmonths() {
		return validmonths;
	}
	public String getStorestatus() {
		return storestatus;
	}
	public String setStorestatus() {
		return storestatus;
	}
	public String getStatusstatereason() {
		return statusstatereason;
	}
	public String setStatusstatereason() {
		return statusstatereason;
	}
	public String getCreateoperid() {
		return createoperid;
	}
	public String setCreateoperid() {
		return createoperid;
	}
	public String getCreateorgid() {
		return createorgid;
	}
	public String setCreateorgid() {
		return createorgid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public Date setCreatedate() {
		return createdate;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public Date setModifydate() {
		return modifydate;
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
