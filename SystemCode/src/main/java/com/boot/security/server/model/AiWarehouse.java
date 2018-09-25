package com.boot.security.server.model;

import java.math.BigDecimal;


public class AiWarehouse extends BaseEntity<Long> {

	private Integer ID;
	private String NAME;
	private String ADDESS;
	private BigDecimal LONGITUDE;
	private BigDecimal LATITUDE;
	private Integer TYPE;
	private Integer USERID;
	private Integer WAREHOUSESTATE;
	private String EXT1;
	private String EXT2;
	private String EXT3;

	public Integer getID() {
		return ID;
	}
	public Integer setID() {
		return ID;
	}
	public String getNAME() {
		return NAME;
	}
	public String setNAME() {
		return NAME;
	}
	public String getADDESS() {
		return ADDESS;
	}
	public String setADDESS() {
		return ADDESS;
	}
	public BigDecimal getLONGITUDE() {
		return LONGITUDE;
	}
	public BigDecimal setLONGITUDE() {
		return LONGITUDE;
	}
	public BigDecimal getLATITUDE() {
		return LATITUDE;
	}
	public BigDecimal setLATITUDE() {
		return LATITUDE;
	}
	public Integer getTYPE() {
		return TYPE;
	}
	public Integer setTYPE() {
		return TYPE;
	}
	public Integer getUSERID() {
		return USERID;
	}
	public Integer setUSERID() {
		return USERID;
	}
	public Integer getWAREHOUSESTATE() {
		return WAREHOUSESTATE;
	}
	public Integer setWAREHOUSESTATE() {
		return WAREHOUSESTATE;
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
