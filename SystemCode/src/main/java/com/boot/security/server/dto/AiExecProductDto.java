package com.boot.security.server.dto;

import com.boot.security.server.enums.DataStatusEnum;
import com.boot.security.server.enums.ProductStatusEnum;
import com.boot.security.server.model.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created By Seven.wk
 * Description: AiExecProduct转换类
 * Created At 2018/09/27
 */
public class AiExecProductDto extends BaseEntity<Long> {

    private String productcode;

    private String aicode;

    private String productname;

    private String productdesc;

    private String producttypeid;

    private BigDecimal productoriprice;

    private String productstatus;

    private String productpicpath;

    private String producturl;

    private Long creatorid;

    private Date createdate;

    private Date modifydate;

    private String datastate;

    private String productsource;

    public AiExecProductDto() {
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getAicode() {
        return aicode;
    }

    public void setAicode(String aicode) {
        this.aicode = aicode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(String producttypeid) {
        this.producttypeid = producttypeid;
    }

    public BigDecimal getProductoriprice() {
        return productoriprice;
    }

    public void setProductoriprice(BigDecimal productoriprice) {
        this.productoriprice = productoriprice;
    }

    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus;
    }

    public String getProductpicpath() {
        return productpicpath;
    }

    public void setProductpicpath(String productpicpath) {
        this.productpicpath = productpicpath;
    }

    public String getProducturl() {
        return producturl;
    }

    public void setProducturl(String producturl) {
        this.producturl = producturl;
    }

    public Long getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Long creatorid) {
        this.creatorid = creatorid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getDatastate() {
        return datastate;
    }

    public void setDatastate(String datastate) {
        this.datastate = datastate;
    }

    public String getProductsource() {
        return productsource;
    }

    public void setProductsource(String productsource) {
        this.productsource = productsource;
    }

    @Override
    public String toString() {
        return "AiExecProductDto{" +
                "productcode='" + productcode + '\'' +
                ", aicode='" + aicode + '\'' +
                ", productname='" + productname + '\'' +
                ", productdesc='" + productdesc + '\'' +
                ", producttypeid='" + producttypeid + '\'' +
                ", productoriprice=" + productoriprice +
                ", productstatus='" + productstatus + '\'' +
                ", productpicpath='" + productpicpath + '\'' +
                ", producturl='" + producturl + '\'' +
                ", creator=" + creatorid +
                ", createdate=" + createdate +
                ", modifydate=" + modifydate +
                ", datastate='" + datastate + '\'' +
                ", productsource='" + productsource + '\'' +
                '}';
    }
}
