package com.boot.security.server.dto;

/**
 * Created By Seven.wk
 * Description: 从Excel导入的product模型
 * Created At 2018/09/20
 */
public class ExcelProduct {

    private String productCode;

    private String aiCode;

    private String productName;

    private String productDesc;

    private String productTypeId;

    private String productOriPrice;

    private String productSource;

    public ExcelProduct() {
    }

    public ExcelProduct(String[] content) {
        productCode = content[0];
        aiCode = content[1];
        productName = content[2];
        productDesc = content[3];
        productTypeId = content[4];
        productOriPrice = content[5];
        productSource = content[6];
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

    public String getAiCode() {
        return aiCode;
    }

    public void setAiCode(String aiCode) {
        this.aiCode = aiCode;
    }

    @Override
    public String toString() {
        return "ExcelProduct{" +
                "productCode='" + productCode + '\'' +
                ", aiCode='" + aiCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productTypeId='" + productTypeId + '\'' +
                ", productOriPrice='" + productOriPrice + '\'' +
                ", productSource='" + productSource + '\'' +
                '}';
    }
}
