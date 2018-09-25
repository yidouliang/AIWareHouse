package com.boot.security.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class OrderThirdLevel extends BaseEntity<Long>{

    @JsonProperty("FIRST_LEVEL_ID")
    private Long firstLevelId;

    @JsonProperty("USER_CODE")
    private String userCode;

    private String telephone;

    @JsonProperty("SERIAL_NUMBER")
    private String serialNumber;

    @JsonProperty("P_SERIAL_NUMBER")
    private String pSerialNumber;

    @JsonProperty("PRODUCT_ORIGIN_PRICE")
    private BigDecimal productOriginPrice;

    @JsonProperty("PRODUCT_SALE_PRICE")
    private BigDecimal productSalePrice;

    @JsonProperty("ORDER_STATUS")
    private Integer orderStatus;

    @JsonProperty("ERROR_CODE")
    private Integer errorCode;

    @JsonProperty("PRODUCT_TYPE_ID")
    private Integer productTypeId;

    @JsonProperty("PRODUCT_TYPE_NAME")
    private String productTypeName;

    @JsonProperty("PRODUCT_NAME")
    private String productName;

    @JsonProperty("PRODUCT_CODE")
    private String productCode;

    @JsonProperty("PRODUCT_IMG_URL")
    private String productImgUrl;

    @JsonProperty("PRODUCT_DESC")
    private String productDesc;

    @JsonProperty("BUY_NUM")
    private Integer buyNum;

    @JsonProperty("ACTIVITY_NAME")
    private String activityName;

    @JsonProperty("MKT_INV_ID")
    private Long mktInvId;

    @JsonProperty("DATA_STATE")
    private char dataState;

    @JsonProperty("EXT_1")
    private String ext1;

    @JsonProperty("EXT_2")
    private String ext2;

    @JsonProperty("EXT_3")
    private String ext3;

    @JsonProperty("EXT_4")
    private String ext4;


    public Long getFirstLevelId() {
        return firstLevelId;
    }

    public void setFirstLevelId(Long firstLevelId) {
        this.firstLevelId = firstLevelId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getpSerialNumber() {
        return pSerialNumber;
    }

    public void setpSerialNumber(String pSerialNumber) {
        this.pSerialNumber = pSerialNumber;
    }

    public BigDecimal getProductOriginPrice() {
        return productOriginPrice;
    }

    public void setProductOriginPrice(BigDecimal productOriginPrice) {
        this.productOriginPrice = productOriginPrice;
    }



    public BigDecimal getProductSalePrice() {
        return productSalePrice;
    }

    public void setProductSalePrice(BigDecimal productSalePrice) {
        this.productSalePrice = productSalePrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }


    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Long getMktInvId() {
        return mktInvId;
    }

    public void setMktInvId(Long mktInvId) {
        this.mktInvId = mktInvId;
    }

    public char getDataState() {
        return dataState;
    }

    public void setDataState(char dataState) {
        this.dataState = dataState;
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

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }
}
