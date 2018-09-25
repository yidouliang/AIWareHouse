package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class ExecProduct extends BaseEntity<Long> {

    private String productCode;
	private String productName;
	private String productDesc;
	private BigDecimal productTypeId;
	private Date productStartTime;
	private Date productEndTime;
	private BigDecimal productPrice;
	private BigDecimal productOriPrice;
	private Integer productStatus;
	private String productPicPath;
	private String kindCode;
	private String rootKindCode;
	private String productUrl;
	private BigDecimal creator;
	private Date creatDate;
	private BigDecimal modeifier;
	private Date modifyDate;
	private Integer dataState;
	private Integer isLock;
	private String srcCode;
	private String productSource;
	private String company;
	private Integer limitNum;
	private Date productSaleTime;
	private String belongAlbum;
	private String ext1;
	private String ext2;
	private String EXT3;
	private String ISNEEDINVINST;

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

	public BigDecimal getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(BigDecimal productTypeId) {
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

	public Integer getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductPicPath() {
		return productPicPath;
	}

	public void setProductPicPath(String productPicPath) {
		this.productPicPath = productPicPath;
	}

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getRootKindCode() {
		return rootKindCode;
	}

	public void setRootKindCode(String rootKindCode) {
		this.rootKindCode = rootKindCode;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public BigDecimal getCreator() {
		return creator;
	}

	public void setCreator(BigDecimal creator) {
		this.creator = creator;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public BigDecimal getModeifier() {
		return modeifier;
	}

	public void setModeifier(BigDecimal modeifier) {
		this.modeifier = modeifier;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getDataState() {
		return dataState;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public String getSrcCode() {
		return srcCode;
	}

	public void setSrcCode(String srcCode) {
		this.srcCode = srcCode;
	}

	public String getProductSource() {
		return productSource;
	}

	public void setProductSource(String productSource) {
		this.productSource = productSource;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public Date getProductSaleTime() {
		return productSaleTime;
	}

	public void setProductSaleTime(Date productSaleTime) {
		this.productSaleTime = productSaleTime;
	}

	public String getBelongAlbum() {
		return belongAlbum;
	}

	public void setBelongAlbum(String belongAlbum) {
		this.belongAlbum = belongAlbum;
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

	public String getEXT3() {
		return EXT3;
	}

	public void setEXT3(String EXT3) {
		this.EXT3 = EXT3;
	}

	public String getISNEEDINVINST() {
		return ISNEEDINVINST;
	}

	public void setISNEEDINVINST(String ISNEEDINVINST) {
		this.ISNEEDINVINST = ISNEEDINVINST;
	}

    @Override
    public String toString() {
        return "ExecProduct{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productTypeId=" + productTypeId +
                ", productStartTime=" + productStartTime +
                ", productEndTime=" + productEndTime +
                ", productPrice=" + productPrice +
                ", productOriPrice=" + productOriPrice +
                ", productSource='" + productSource + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
