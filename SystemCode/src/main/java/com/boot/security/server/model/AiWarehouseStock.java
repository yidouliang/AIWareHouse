package com.boot.security.server.model;

import com.boot.security.server.enums.DataStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

public class AiWarehouseStock extends BaseEntity<Long> {

	private Long prodinstid;
	private String productname;
	private String productcode;
	private Integer allnum;
	private Integer remaindnum;
	private String aicode;
	private Integer userid;
	private BigDecimal oldprice;
	private BigDecimal nowprice;
	private Long warehouseid;
	private BigDecimal discount;
	private String batchid;
	private String supplier;
	private Date factorydate;
	private Date validmonths;
	private String storestatus;
	private String statusstatereason;
	private Long createoperid;
	private Long createorgid;
	private Date createdate = new Date();
	private Date modifydate = new Date();
	private Integer datastate = DataStatusEnum.NORMAL.getCode();
	private String ext1;
	private String ext2;
	private String ext3;

	public AiWarehouseStock() {
	}

	public Long getProdinstid() {
		return prodinstid;
	}

	public void setProdinstid(Long prodinstid) {
		this.prodinstid = prodinstid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public void setDatastate(Integer datastate) {
		this.datastate = datastate;
	}

	public Integer getAllnum() {
		return allnum;
	}

	public void setAllnum(Integer allnum) {
		this.allnum = allnum;
	}

	public Integer getRemaindnum() {
		return remaindnum;
	}

	public void setRemaindnum(Integer remaindnum) {
		this.remaindnum = remaindnum;
	}

	public String getAicode() {
		return aicode;
	}

	public void setAicode(String aicode) {
		this.aicode = aicode;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public BigDecimal getOldprice() {
		return oldprice;
	}

	public void setOldprice(BigDecimal oldprice) {
		this.oldprice = oldprice;
	}

	public BigDecimal getNowprice() {
		return nowprice;
	}

	public void setNowprice(BigDecimal nowprice) {
		this.nowprice = nowprice;
	}

	public Long getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(Long warehouseid) {
		this.warehouseid = warehouseid;
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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

	public String getStorestatus() {
		return storestatus;
	}

	public void setStorestatus(String storestatus) {
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

}
