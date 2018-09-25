package com.boot.security.server.model;



public class MktBox extends BaseEntity<Long> {

	private String boxName;
	private String boxCode;
	private String boxType;
	private String boxPerson;
	private String address;
	private String status;
	private String personTelphone;

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
	public String getBoxPerson() {
		return boxPerson;
	}
	public String setBoxPerson() {
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
	public String getPersonTelphone() {
		return personTelphone;
	}
	public String setPersonTelphone() {
		return personTelphone;
	}

}
