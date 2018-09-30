package com.boot.security.server.dto;

import com.boot.security.server.model.BaseEntity;

import java.math.BigDecimal;

public class AiOrderThirdLevelDto extends BaseEntity<Long> {

    private Long firstlevelid;
    private Long mktinvid;
    private String usercode;
    private String telephone;
    private String serialnumber;
    private String boxname;
    //用于显示的盒子类型
    private String boxtype;
    private String pserialnumber;
    private BigDecimal productprice;
    //用于显示的产品类型
    private String producttypeid;
    private String productname;
    private String productcode;
    private String productimgurl;
    private String productdesc;
    private Integer buynum;
    private Integer activityid;
    private String activityname;
    //用于显示的数据状态
    private String datastate;

    public Long getFirstlevelid() {
        return firstlevelid;
    }

    public void setFirstlevelid(Long firstlevelid) {
        this.firstlevelid = firstlevelid;
    }

    public Long getMktinvid() {
        return mktinvid;
    }

    public void setMktinvid(Long mktinvid) {
        this.mktinvid = mktinvid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getBoxname() {
        return boxname;
    }

    public void setBoxname(String boxname) {
        this.boxname = boxname;
    }

    public String getBoxtype() {
        return boxtype;
    }

    public void setBoxtype(String boxtype) {
        this.boxtype = boxtype;
    }

    public String getPserialnumber() {
        return pserialnumber;
    }

    public void setPserialnumber(String pserialnumber) {
        this.pserialnumber = pserialnumber;
    }

    public BigDecimal getProductprice() {
        return productprice;
    }

    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    public String getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(String producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductimgurl() {
        return productimgurl;
    }

    public void setProductimgurl(String productimgurl) {
        this.productimgurl = productimgurl;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getDatastate() {
        return datastate;
    }

    public void setDatastate(String datastate) {
        this.datastate = datastate;
    }
}
