package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiMktBox extends BaseEntity<Long> {

	private String boxName;
	private String boxCode;
	private String boxType;
	private Integer boxPerson;
	private String address;
	private String status;
	private Date FACTORYDATE;
	private Integer PAYSTATE;
	private Integer BOXWAREHOUSEID;
	private Date ENDDATE;
	private String personTelphone;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private String EXT1;
	private String EXT2;
	private String EXT3;

	public String getBoxName() {
		return boxName;
	}
	public String setBoxName() {
		return boxName;
	}
	public String getBoxCode() {
		return boxCode;
	}
	public String setBoxCode() {
		return boxCode;
	}
	public String getBoxType() {
		return boxType;
	}
	public String setBoxType() {
		return boxType;
	}
	public Integer getBoxPerson() {
		return boxPerson;
	}
	public Integer setBoxPerson() {
		return boxPerson;
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
	public Date getFACTORYDATE() {
		return FACTORYDATE;
	}
	public Date setFACTORYDATE() {
		return FACTORYDATE;
	}
	public Integer getPAYSTATE() {
		return PAYSTATE;
	}
	public Integer setPAYSTATE() {
		return PAYSTATE;
	}
	public Integer getBOXWAREHOUSEID() {
		return BOXWAREHOUSEID;
	}
	public Integer setBOXWAREHOUSEID() {
		return BOXWAREHOUSEID;
	}
	public Date getENDDATE() {
		return ENDDATE;
	}
	public Date setENDDATE() {
		return ENDDATE;
	}
	public String getPersonTelphone() {
		return personTelphone;
	}
	public String setPersonTelphone() {
		return personTelphone;
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
	public String getEXT1() {
		return EXT1;
	}
	public String setEXT1() {
		return EXT1;
	}
	public String getEXT2() {
		return EXT2;
	}
	public String setEXT2() {
		return EXT2;
	}
	public String getEXT3() {
		return EXT3;
	}
	public String setEXT3() {
		return EXT3;
	}

}
