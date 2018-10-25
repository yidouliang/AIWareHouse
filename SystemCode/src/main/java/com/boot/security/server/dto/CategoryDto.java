package com.boot.security.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created By Seven.wk
 * Description: 类目传输模型
 * Created At 2018/10/17
 */
public class CategoryDto {

    private Long id;

    @JsonProperty("name")
    private String title;

    @JsonProperty("pId")
    private Long pid;

    public CategoryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
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
