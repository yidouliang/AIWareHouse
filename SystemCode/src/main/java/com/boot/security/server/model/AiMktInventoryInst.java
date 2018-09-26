package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiMktInventoryInst extends BaseEntity<Long> {

	private BigDecimal prodinstid;
	private String productcode;
	private String productname;
	private String serialno;
	private Integer userid;
	private BigDecimal originprice;
	private BigDecimal saleprice;
	private Integer boxid;
	private BigDecimal discount;
	private String batchid;
	private String supplier;
	private Date factorydate;
	private Date validmonths;
	private String storestatus;
	private String statusstatereason;
	private String createoperId;
	private String createorgid;
	private Date createdate;
	private String modifydate;
	private Integer datastate;
	private String ext1;
	private String ext2;
	private String ext3;

	public BigDecimal getProdinstid() {
		return prodinstid;
	}
	public BigDecimal setProdinstid() {
		return prodinstid;
	}
	public String getProductcode() {
		return productcode;
	}
	public String setProductcode() {
		return productcode;
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
	public Integer getUserid() {
		return userid;
	}
	public Integer setUserid() {
		return userid;
	}
	public BigDecimal getOriginprice() {
		return originprice;
	}
	public BigDecimal setOriginprice() {
		return originprice;
	}
	public BigDecimal getSaleprice() {
		return saleprice;
	}
	public BigDecimal setSaleprice() {
		return saleprice;
	}
	public Integer getBoxid() {
		return boxid;
	}
	public Integer setBoxid() {
		return boxid;
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
	public String getCreateoperId() {
		return createoperId;
	}
	public String setCreateoperId() {
		return createoperId;
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
	public String getModifydate() {
		return modifydate;
	}
	public String setModifydate() {
		return modifydate;
	}
	public Integer getDatastate() {
		return datastate;
	}
	public Integer setDatastate() {
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
