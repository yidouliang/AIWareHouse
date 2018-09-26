package com.boot.security.server.model;

import java.math.BigDecimal;


public class AiWarehouse extends BaseEntity<Long> {

	private String name;
	private String address;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private Integer type;
	private Integer userid;
	private Integer warehousestate;
	private String ext1;
	private String ext2;
	private String ext3;

	public String getName() {
		return name;
	}
	public String setName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String setAddress() {
		return address;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public BigDecimal setLongitude() {
		return longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public BigDecimal setLatitude() {
		return latitude;
	}
	public Integer getType() {
		return type;
	}
	public Integer setType() {
		return type;
	}
	public Integer getUserid() {
		return userid;
	}
	public Integer setUserid() {
		return userid;
	}
	public Integer getWarehousestate() {
		return warehousestate;
	}
	public Integer setWarehousestate() {
		return warehousestate;
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
