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
	private BigDecimal creator;
	private Date createdate = new Date();
	private Date modifydate = new Date();
	private Integer datastate = DataStatusEnum.NORMAL.getCode();
	private String productsource;
	private Integer ext1;
	private String ext2;
	private String ext3;

	public String getProductcode() {
		return productcode;
	}
	public String setProductcode() {
		return productcode;
	}
	public String getAicode() {
		return aicode;
	}
	public String setAicode() {
		return aicode;
	}
	public String getProductname() {
		return productname;
	}
	public String setProductname() {
		return productname;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public String setProductdesc() {
		return productdesc;
	}
	public Integer getProducttypeid() {
		return producttypeid;
	}
	public Integer setProducttypeid() {
		return producttypeid;
	}
	public BigDecimal getProductoriprice() {
		return productoriprice;
	}
	public BigDecimal setProductoriprice() {
		return productoriprice;
	}
	public Integer getProductstatus() {
		return productstatus;
	}
	public Integer setProductstatus() {
		return productstatus;
	}
	public String getProductpicpath() {
		return productpicpath;
	}
	public String setProductpicpath() {
		return productpicpath;
	}
	public String getProducturl() {
		return producturl;
	}
	public String setProducturl() {
		return producturl;
	}
	public BigDecimal getCreator() {
		return creator;
	}
	public BigDecimal setCreator() {
		return creator;
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
	public Integer getDatastate() {
		return datastate;
	}
	public Integer setDatastate() {
		return datastate;
	}
	public String getProductsource() {
		return productsource;
	}
	public String setProductsource() {
		return productsource;
	}
	public Integer getExt1() {
		return ext1;
	}
	public Integer setExt1() {
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
