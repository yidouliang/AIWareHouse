package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class Resourceproduct extends BaseEntity<Long> {

	private String productname;
	private Integer totalnum;
	private Integer remainnum;
	private Integer creator;
	private Date creattime;
	private Date updatetime;
	private BigDecimal price;
	private BigDecimal originprice;
	private BigDecimal discount;
	private String region;
	private String remark;
	private Integer userid;
	private String ext1;
	private String ext2;
	private String ext3;

	public String getProductname() {
		return productname;
	}
	public String setProductname() {
		return productname;
	}
	public Integer getTotalnum() {
		return totalnum;
	}
	public Integer setTotalnum() {
		return totalnum;
	}
	public Integer getRemainnum() {
		return remainnum;
	}
	public Integer setRemainnum() {
		return remainnum;
	}
	public Integer getCreator() {
		return creator;
	}
	public Integer setCreator() {
		return creator;
	}
	public Date getCreattime() {
		return creattime;
	}
	public Date setCreattime() {
		return creattime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public Date setUpdatetime() {
		return updatetime;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public BigDecimal setPrice() {
		return price;
	}
	public BigDecimal getOriginprice() {
		return originprice;
	}
	public BigDecimal setOriginprice() {
		return originprice;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public BigDecimal setDiscount() {
		return discount;
	}
	public String getRegion() {
		return region;
	}
	public String setRegion() {
		return region;
	}
	public String getRemark() {
		return remark;
	}
	public String setRemark() {
		return remark;
	}
	public Integer getUserid() {
		return userid;
	}
	public Integer setUserid() {
		return userid;
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
