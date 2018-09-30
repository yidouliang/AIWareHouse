package com.boot.security.server.model;

import com.boot.security.server.enums.DataStatusEnum;
import com.boot.security.server.utils.ConstUtil;

import java.math.BigDecimal;
import java.util.Date;

public class AiCupboardInventoryInst extends BaseEntity<Long> {

	private BigDecimal prodinstid;
	private String productname;
	private Long productcode;
	private Integer allnum;
	private Integer remindnum;
	private Integer userid;
	private BigDecimal originprice;
	private BigDecimal saleprice;
	private Long boxid;
	private BigDecimal discount;
	private String batchid;
	private Long warehouseid;
	private Date factorydate;
	private Date validmonths;
	private Integer storestatus;
	private String statusstatereason;
	private Long createoperid;
	private Long createorgid;
	private Date createdate = new Date();
	private Date modifydate = new Date();
	private Integer datastate = DataStatusEnum.NORMAL.getCode();
	private String ext1;
	private String ext2;
	private String ext3;
	private String aicode;

	public AiCupboardInventoryInst() {
	}

	public BigDecimal getProdinstid() {
		return prodinstid;
	}

	public void setProdinstid(BigDecimal prodinstid) {
		this.prodinstid = prodinstid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Long getProductcode() {
		return productcode;
	}

	public void setProductcode(Long productcode) {
		this.productcode = productcode;
	}

	public Integer getAllnum() {
		return allnum;
	}

	public void setAllnum(Integer allnum) {
		this.allnum = allnum;
	}

	public Integer getRemindnum() {
		return remindnum;
	}

	public void setRemindnum(Integer remindnum) {
		this.remindnum = remindnum;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public BigDecimal getOriginprice() {
		return originprice;
	}

	public void setOriginprice(BigDecimal originprice) {
		this.originprice = originprice;
	}

	public BigDecimal getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(BigDecimal saleprice) {
		this.saleprice = saleprice;
	}

	public Long getBoxid() {
		return boxid;
	}

	public void setBoxid(Long boxid) {
		this.boxid = boxid;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getBatchid() {
		return batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	public Long getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(Long warehouseid) {
		this.warehouseid = warehouseid;
	}

	public Date getFactorydate() {
		return factorydate;
	}

	public void setFactorydate(Date factorydate) {
		this.factorydate = factorydate;
	}

	public Date getValidmonths() {
		return validmonths;
	}

	public void setValidmonths(Date validmonths) {
		this.validmonths = validmonths;
	}

	public Integer getStorestatus() {
		return storestatus;
	}

	public void setStorestatus(Integer storestatus) {
		this.storestatus = storestatus;
	}

	public String getStatusstatereason() {
		return statusstatereason;
	}

	public void setStatusstatereason(String statusstatereason) {
		this.statusstatereason = statusstatereason;
	}

	public Long getCreateoperid() {
		return createoperid;
	}

	public void setCreateoperid(Long createoperid) {
		this.createoperid = createoperid;
	}

	public Long getCreateorgid() {
		return createorgid;
	}

	public void setCreateorgid(Long createorgid) {
		this.createorgid = createorgid;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public Integer getDatastate() {
		return datastate;
	}

	public void setDatastate(Integer datastate) {
		this.datastate = datastate;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getAicode() {
		return aicode;
	}

	public void setAicode(String aicode) {
		this.aicode = aicode;
	}
}
