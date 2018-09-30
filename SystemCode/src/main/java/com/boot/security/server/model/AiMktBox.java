package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiMktBox extends BaseEntity<Long> {

	private String boxname;
	private String boxcode;
	private Integer boxtype;
	private Long boxperson;
	private String address;
	private Integer status;
	private Date factorydate;
	private Integer paystate;
	private Long boxwarehouseid;
	private Date enddate;
	private String persontelphone;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private String ext1;
	private String ext2;
	private String ext3;

	@Override
	public String toString() {
		return "AiMktBox{" +
				"boxname='" + boxname + '\'' +
				", boxcode='" + boxcode + '\'' +
				", boxtype=" + boxtype +
				", boxperson=" + boxperson +
				", address='" + address + '\'' +
				", status=" + status +
				", factorydate=" + factorydate +
				", paystate=" + paystate +
				", boxwarehouseid=" + boxwarehouseid +
				", enddate=" + enddate +
				", persontelphone='" + persontelphone + '\'' +
				", longitude=" + longitude +
				", latitude=" + latitude +
				", ext1='" + ext1 + '\'' +
				", ext2='" + ext2 + '\'' +
				", ext3='" + ext3 + '\'' +
				'}';
	}

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

	public Integer getBoxtype() {
		return boxtype;
	}

	public void setBoxtype(Integer boxtype) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Long getBoxwarehouseid() {
		return boxwarehouseid;
	}

	public void setBoxwarehouseid(Long boxwarehouseid) {
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
}
