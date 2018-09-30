package com.boot.security.server.model;

import com.boot.security.server.enums.DataStatusEnum;
import com.boot.security.server.enums.ProductStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

public class AiExecProduct extends BaseEntity<Long> {

	private String productcode;
	private String aicode;
	private String productname;
	private String productdesc;
	private Integer producttypeid;
	private BigDecimal productoriprice;
	private Integer productstatus = ProductStatusEnum.OBTAINED.getCode();
	private String productpicpath;
	private String producturl;
	private Long creatorid;
	private Date createdate = new Date();
	private Date modifydate = new Date();
	private Integer datastate = DataStatusEnum.NORMAL.getCode();
	private String productsource;
	private Integer ext1;
	private String ext2;
	private String ext3;

	public AiExecProduct() {
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getAicode() {
		return aicode;
	}

	public void setAicode(String aicode) {
		this.aicode = aicode;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public Integer getProducttypeid() {
		return producttypeid;
	}

	public void setProducttypeid(Integer producttypeid) {
		this.producttypeid = producttypeid;
	}

	public BigDecimal getProductoriprice() {
		return productoriprice;
	}

	public void setProductoriprice(BigDecimal productoriprice) {
		this.productoriprice = productoriprice;
	}

	public Integer getProductstatus() {
		return productstatus;
	}

	public void setProductstatus(Integer productstatus) {
		this.productstatus = productstatus;
	}

	public String getProductpicpath() {
		return productpicpath;
	}

	public void setProductpicpath(String productpicpath) {
		this.productpicpath = productpicpath;
	}

	public String getProducturl() {
		return producturl;
	}

	public void setProducturl(String producturl) {
		this.producturl = producturl;
	}

	public Long getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(Long creatorid) {
		this.creatorid = creatorid;
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

	public String getProductsource() {
		return productsource;
	}

	public void setProductsource(String productsource) {
		this.productsource = productsource;
	}
}
