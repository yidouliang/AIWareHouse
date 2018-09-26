package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiMktBox extends BaseEntity<Long> {

	private String boxname;
	private String boxcode;
	private String boxtype;
	private Integer boxperson;
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
	public String setBoxname() {
		return boxname;
	}
	public String getBoxcode() {
		return boxcode;
	}
	public String setBoxcode() {
		return boxcode;
	}
	public String getBoxtype() {
		return boxtype;
	}
	public String setBoxtype() {
		return boxtype;
	}
	public Integer getBoxperson() {
		return boxperson;
	}
	public Integer setBoxperson() {
		return boxperson;
	}
	public String getAddress() {
		return address;
	}
	public String setAddress() {
		return address;
	}
	public String getStatus() {
		return status;
	}
	public String setStatus() {
		return status;
	}
	public Date getFactorydate() {
		return factorydate;
	}
	public Date setFactorydate() {
		return factorydate;
	}
	public Integer getPaystate() {
		return paystate;
	}
	public Integer setPaystate() {
		return paystate;
	}
	public Integer getBoxwarehouseid() {
		return boxwarehouseid;
	}
	public Integer setBoxwarehouseid() {
		return boxwarehouseid;
	}
	public Date getEnddate() {
		return enddate;
	}
	public Date setEnddate() {
		return enddate;
	}
	public String getPersontelphone() {
		return persontelphone;
	}
	public String setPersontelphone() {
		return persontelphone;
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
