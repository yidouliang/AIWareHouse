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

    private String productOriPrice;

    private String productSource;

    public ExcelProduct() {
    }

    public ExcelProduct(String[] content) {
        productCode = content[0];
        productName = content[1];
        productDesc = content[2];
        productTypeId = content[3];
        productOriPrice = content[4];
        productSource = content[5];
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

    public String getProductOriPrice() {
        return productOriPrice;
    }

    public void setProductOriPrice(String productOriPrice) {
        this.productOriPrice = productOriPrice;
    }

    public String getProductSource() {
        return productSource;
    }

    public void setProductSource(String productSource) {
        this.productSource = productSource;
    }

    @Override
    public String toString() {
        return "ExcelProduct{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productTypeId='" + productTypeId + '\'' +
                ", productOriPrice='" + productOriPrice + '\'' +
                ", productSource='" + productSource + '\'' +
                '}';
    }
}
