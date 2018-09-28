package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiMktBox extends BaseEntity<Long> {

	private String boxname;
	private String boxcode;
	private String boxtype;
	private Long boxperson;
	private String address;
	private String status;
	private Date factorydate;
	private Integer paystate;
	private Integer boxwarehouseid;
	private Date enddate;
	private String persontelphone;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private String ext1;
	private String ext2;
	private String ext3;

	public String getBoxname() {
		return boxname;
	}

	public void setBoxname(String boxname) {
		this.boxname = boxname;
	}

	public String getBoxcode() {
		return boxcode;
	}

	public void setBoxcode(String boxcode) {
		this.boxcode = boxcode;
	}

	public String getBoxtype() {
		return boxtype;
	}

	public void setBoxtype(String boxtype) {
		this.boxtype = boxtype;
	}

	public Long getBoxperson() {
		return boxperson;
	}

	public void setBoxperson(Long boxperson) {
		this.boxperson = boxperson;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFactorydate() {
		return factorydate;
	}

	public void setFactorydate(Date factorydate) {
		this.factorydate = factorydate;
	}

	public Integer getPaystate() {
		return paystate;
	}

	public void setPaystate(Integer paystate) {
		this.paystate = paystate;
	}

	public Integer getBoxwarehouseid() {
		return boxwarehouseid;
	}

	public void setBoxwarehouseid(Integer boxwarehouseid) {
		this.boxwarehouseid = boxwarehouseid;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getPersontelphone() {
		return persontelphone;
	}

	public void setPersontelphone(String persontelphone) {
		this.persontelphone = persontelphone;
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
}
