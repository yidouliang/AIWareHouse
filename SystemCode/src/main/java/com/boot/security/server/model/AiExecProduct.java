package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiExecProduct extends BaseEntity<Long> {

	private String PRODUCTCODE;
	private String AICODE;
	private String PRODUCTNAME;
	private String PRODUCTDESC;
	private Integer PRODUCTTYPEID;
	private BigDecimal PRODUCTORIPRICE;
	private Integer PRODUCTSTATUS;
	private String PRODUCTPICPATH;
	private String PRODUCTURL;
	private BigDecimal CREATOR;
	private Date CREATEDATE;
	private Date MODIFYDATE;
	private Integer DATASTATE;
	private String PRODUCTSOURCE;
	private Integer EXT1;
	private String EXT2;
	private String EXT3;

	public String getPRODUCTCODE() {
		return PRODUCTCODE;
	}
	public String setPRODUCTCODE() {
		return PRODUCTCODE;
	}
	public String getAICODE() {
		return AICODE;
	}
	public String setAICODE() {
		return AICODE;
	}
	public String getPRODUCTNAME() {
		return PRODUCTNAME;
	}
	public String setPRODUCTNAME() {
		return PRODUCTNAME;
	}
	public String getPRODUCTDESC() {
		return PRODUCTDESC;
	}
	public String setPRODUCTDESC() {
		return PRODUCTDESC;
	}
	public Integer getPRODUCTTYPEID() {
		return PRODUCTTYPEID;
	}
	public Integer setPRODUCTTYPEID() {
		return PRODUCTTYPEID;
	}
	public BigDecimal getPRODUCTORIPRICE() {
		return PRODUCTORIPRICE;
	}
	public BigDecimal setPRODUCTORIPRICE() {
		return PRODUCTORIPRICE;
	}
	public Integer getPRODUCTSTATUS() {
		return PRODUCTSTATUS;
	}
	public Integer setPRODUCTSTATUS() {
		return PRODUCTSTATUS;
	}
	public String getPRODUCTPICPATH() {
		return PRODUCTPICPATH;
	}
	public String setPRODUCTPICPATH() {
		return PRODUCTPICPATH;
	}
	public String getPRODUCTURL() {
		return PRODUCTURL;
	}
	public String setPRODUCTURL() {
		return PRODUCTURL;
	}
	public BigDecimal getCREATOR() {
		return CREATOR;
	}
	public BigDecimal setCREATOR() {
		return CREATOR;
	}
	public Date getCREATEDATE() {
		return CREATEDATE;
	}
	public Date setCREATEDATE() {
		return CREATEDATE;
	}
	public Date getMODIFYDATE() {
		return MODIFYDATE;
	}
	public Date setMODIFYDATE() {
		return MODIFYDATE;
	}
	public Integer getDATASTATE() {
		return DATASTATE;
	}
	public Integer setDATASTATE() {
		return DATASTATE;
	}
	public String getPRODUCTSOURCE() {
		return PRODUCTSOURCE;
	}
	public String setPRODUCTSOURCE() {
		return PRODUCTSOURCE;
	}
	public Integer getEXT1() {
		return EXT1;
	}
	public Integer setEXT1() {
		return EXT1;
	}
	public String getEXT2() {
		return EXT2;
	}
	public String setEXT2() {
		return EXT2;
	}
	public String getEXT3() {
		return EXT3;
	}
	public String setEXT3() {
		return EXT3;
	}

}
