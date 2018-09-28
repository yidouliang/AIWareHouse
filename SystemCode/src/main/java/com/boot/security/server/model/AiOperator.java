package com.boot.security.server.model;



public class AiOperator extends BaseEntity<Long> {

	private String name;
	private String description;
	private Integer level;
	private String ext4;
	private String ext5;
	private String ext6;
	private String ext1;
	private String ext2;
	private Integer owernum;
	private Integer userid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	public String getExt6() {
		return ext6;
	}

	public void setExt6(String ext6) {
		this.ext6 = ext6;
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

	public Integer getOwernum() {
		return owernum;
	}

	public void setOwernum(Integer owernum) {
		this.owernum = owernum;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
