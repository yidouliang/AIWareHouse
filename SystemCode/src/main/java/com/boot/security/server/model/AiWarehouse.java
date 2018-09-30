package com.boot.security.server.model;

import java.math.BigDecimal;


public class AiWarehouse extends BaseEntity<Long> {

	private String name;
	private String address;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private Integer type;
	private Long operatorid;
	private Integer warehousestate;
	private String ext1;
	private String ext2;
	private String ext3;

	public AiWarehouse() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(Long operatorid) {
		this.operatorid = operatorid;
	}

	public Integer getWarehousestate() {
		return warehousestate;
	}

	public void setWarehousestate(Integer warehousestate) {
		this.warehousestate = warehousestate;
	}
}
