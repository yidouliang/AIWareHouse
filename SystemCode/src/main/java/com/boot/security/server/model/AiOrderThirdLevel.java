package com.boot.security.server.model;

import java.math.BigDecimal;


public class AiOrderThirdLevel extends BaseEntity<Long> {

	private String firstlevelid;
	private Long mktinvid;
	private String usercode;
	private String telephone;
	private String serialnumber;
	private String boxname;
	private Integer boxtype;
	private String pserialnumber;
	private BigDecimal productprice;
	private Integer producttypeid;
	private String productname;
	private String productcode;
	private String productimgurl;
	private String productdesc;
	private Integer buynum;
	private Integer activityid;
	private String activityname;
	private String datastate;
	private String ext1;
	private String ext2;
	private String ext3;
	private String ext4;

	public String getFirstlevelid() {
		return firstlevelid;
	}

	public void setFirstlevelid(String firstlevelid) {
		this.firstlevelid = firstlevelid;
	}

	public Long getMktinvid() {
		return mktinvid;
	}

	public void setMktinvid(Long mktinvid) {
		this.mktinvid = mktinvid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getBoxname() {
		return boxname;
	}

	public void setBoxname(String boxname) {
		this.boxname = boxname;
	}

	public Integer getBoxtype() {
		return boxtype;
	}

	public void setBoxtype(Integer boxtype) {
		this.boxtype = boxtype;
	}

	public String getPserialnumber() {
		return pserialnumber;
	}

	public void setPserialnumber(String pserialnumber) {
		this.pserialnumber = pserialnumber;
	}

	public BigDecimal getProductprice() {
		return productprice;
	}

	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}

	public Integer getProducttypeid() {
		return producttypeid;
	}

	public void setProducttypeid(Integer producttypeid) {
		this.producttypeid = producttypeid;
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

	public String getProductimgurl() {
		return productimgurl;
	}

	public void setProductimgurl(String productimgurl) {
		this.productimgurl = productimgurl;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public Integer getBuynum() {
		return buynum;
	}

	public void setBuynum(Integer buynum) {
		this.buynum = buynum;
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}

	public String getDatastate() {
		return datastate;
	}

	public void setDatastate(String datastate) {
		this.datastate = datastate;
	}
}
