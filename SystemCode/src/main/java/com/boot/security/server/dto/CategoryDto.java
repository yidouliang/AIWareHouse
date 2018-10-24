package com.boot.security.server.dto;

/**
 * Created By Seven.wk
 * Description: 类目传输模型
 * Created At 2018/10/17
 */
public class CategoryDto {

    private Integer id;

    private String title;

    private Integer pid;

    public CategoryDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pid=" + pid +
                '}';
    }
}
