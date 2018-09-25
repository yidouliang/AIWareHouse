package com.boot.security.server.dto;

import com.boot.security.server.model.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created By Seven.wk
 * Description: 产品传输模型，主要是将ExecProduct中的部分字段进行转化
 * Created At 2018/09/21
 */
public class ExecProductDto extends BaseEntity<Long> {

    private String productCode;
    private String productName;
    private String productDesc;
    private String productTypeId;
    private Date productStartTime;
    private Date productEndTime;
    private BigDecimal productPrice;
    private BigDecimal productOriPrice;
    private String productStatus;
    private String ISNEEDINVINST;
    private String productPicPath;

    public ExecProductDto() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Date getProductStartTime() {
        return productStartTime;
    }

    public void setProductStartTime(Date productStartTime) {
        this.productStartTime = productStartTime;
    }

    public Date getProductEndTime() {
        return productEndTime;
    }

    public void setProductEndTime(Date productEndTime) {
        this.productEndTime = productEndTime;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductOriPrice() {
        return productOriPrice;
    }

    public void setProductOriPrice(BigDecimal productOriPrice) {
        this.productOriPrice = productOriPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getISNEEDINVINST() {
        return ISNEEDINVINST;
    }

    public void setISNEEDINVINST(String ISNEEDINVINST) {
        this.ISNEEDINVINST = ISNEEDINVINST;
    }

    public String getProductPicPath() {
        return productPicPath;
    }

    public void setProductPicPath(String productPicPath) {
        this.productPicPath = productPicPath;
    }

    @Override
    public String toString() {
        return "ExecProductDto{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productTypeId='" + productTypeId + '\'' +
                ", productStartTime=" + productStartTime +
                ", productEndTime=" + productEndTime +
                ", productPrice=" + productPrice +
                ", productOriPrice=" + productOriPrice +
                ", productStatus='" + productStatus + '\'' +
                ", ISNEEDINVINST='" + ISNEEDINVINST + '\'' +
                ", productPicPath='" + productPicPath + '\'' +
                '}';
    }
}
