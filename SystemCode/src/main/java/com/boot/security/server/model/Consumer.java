package com.boot.security.server.model;



public class Consumer extends BaseEntity<Long> {

	private String consumerid;
	private String name;
	private String telphone;
	private Integer type;
	private Integer starcode;
	private Integer source;
	private String descinfo;
	private Integer state;
	private String boxidreg;
	private String ext1;
	private String ext2;
	private String ext3;

	public Consumer() {
	}

	public String getConsumerid() {
		return consumerid;
	}

	public void setConsumerid(String consumerid) {
		this.consumerid = consumerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStarcode() {
		return starcode;
	}

	public void setStarcode(Integer starcode) {
		this.starcode = starcode;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getDescinfo() {
		return descinfo;
	}

	public void setDescinfo(String descinfo) {
		this.descinfo = descinfo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getBoxidreg() {
		return boxidreg;
	}

	public void setBoxidreg(String boxidreg) {
		this.boxidreg = boxidreg;
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
