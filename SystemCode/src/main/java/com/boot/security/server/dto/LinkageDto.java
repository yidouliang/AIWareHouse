package com.boot.security.server.dto;

/**
 * Created By Seven.wk
 * Description: 作为联动数据的转换模型
 * Created At 2018/10/09
 */
public class LinkageDto {

    private Long id;
    private String categoryname;
    private String parentid;

    public LinkageDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "LinkageDto{" +
                "id=" + id +
                ", categoryname='" + categoryname + '\'' +
                ", parentid='" + parentid + '\'' +
                '}';
    }
}
