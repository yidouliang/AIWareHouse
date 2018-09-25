package com.boot.security.server.dto;

/**
 * Created By Seven.wk
 * Description: 从Excel导入的product模型
 * Created At 2018/09/20
 */
public class ExcelProduct {

    private String productCode;

    private String productName;

    private String productDesc;

    private String productTypeId;

    private String productStartTime;

    private String productEndTime;

    private String productPrice;

    private String productOriPrice;

    private String company;

    private String productSource;

    public ExcelProduct() {
    }

    public ExcelProduct(String[] content) {
        productCode = content[0];
        productName = content[1];
        productDesc = content[2];
        productTypeId = content[3];
        productStartTime = content[4];
        productEndTime = content[5];
        productPrice = content[6];
        productOriPrice = content[7];
        company = content[8];
        productSource = content[9];
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

    public String getProductStartTime() {
        return productStartTime;
    }

    public void setProductStartTime(String productStartTime) {
        this.productStartTime = productStartTime;
    }

    public String getProductEndTime() {
        return productEndTime;
    }

    public void setProductEndTime(String productEndTime) {
        this.productEndTime = productEndTime;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductOriPrice() {
        return productOriPrice;
    }

    public void setProductOriPrice(String productOriPrice) {
        this.productOriPrice = productOriPrice;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProductSource() {
        return productSource;
    }

    public void setProductSource(String productSource) {
        this.productSource = productSource;
    }
}
