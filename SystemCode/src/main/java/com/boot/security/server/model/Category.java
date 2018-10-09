package com.boot.security.server.model;

import java.util.Date;

public class Category extends BaseEntity<Long> {

	private String categoryname;
	private String parentid;
	private Integer status;
	private Date createtime;
	private Date updatetime;
	private Integer isleaf;

	public String getCategoryname() {
		return categoryname;
	}
	public String setCategoryname() {
		return categoryname;
	}
	public String getParentid() {
		return parentid;
	}
	public String setParentid() {
		return parentid;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer setStatus() {
		return status;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public Date setCreatetime() {
		return createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public Date setUpdatetime() {
		return updatetime;
	}
	public Integer getIsleaf() {
		return isleaf;
	}
	public Integer setIsleaf() {
		return isleaf;
	}

}
