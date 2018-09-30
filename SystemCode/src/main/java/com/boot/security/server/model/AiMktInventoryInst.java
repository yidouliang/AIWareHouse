package com.boot.security.server.model;

import com.boot.security.server.enums.DataStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

public class AiMktInventoryInst extends BaseEntity<Long> {

	private Long prodinstid;
	private String productcode;
	private String productname;
	private Long rfid;
	private Long userid;
	private BigDecimal originprice;
	private BigDecimal saleprice;
	private Long boxid;
	private BigDecimal discount = new BigDecimal(1);        //默认不打折
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

	public AiMktInventoryInst() {
	}

	public Long getProdinstid() {
		return prodinstid;
	}

	public void setProdinstid(Long prodinstid) {
		this.prodinstid = prodinstid;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
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

	public Long getRfid() {
		return rfid;
	}

	public void setRfid(Long rfid) {
		this.rfid = rfid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getBoxid() {
		return boxid;
	}

	public void setBoxid(Long boxid) {
		this.boxid = boxid;
	}

	public Long getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(Long warehouseid) {
		this.warehouseid = warehouseid;
	}

	public Integer getStorestatus() {
		return storestatus;
	}

	public void setStorestatus(Integer storestatus) {
		this.storestatus = storestatus;
	}
}
