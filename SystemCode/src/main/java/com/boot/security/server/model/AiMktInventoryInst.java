package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class AiMktInventoryInst extends BaseEntity<Long> {

	private String ID;
	private BigDecimal PRODINSTID;
	private String PRODUCTCODE;
	private String PRODUCTNAME;
	private String SERIALNO;
	private Integer USERID;
	private BigDecimal 原价格;
	private BigDecimal 现在价格;
	private Integer BOXID;
	private BigDecimal 折扣率;
	private String BATCHID;
	private String SUPPLIER;
	private Date FACTORYDATE;
	private Date VALIDMONTHS;
	private String STORESTATUS;
	private String STATUSSTATEREASON;
	private String CREATEOPERID;
	private String CREATEORGID;
	private Date CREATEDATE;
	private String MODIFYDATE;
	private Integer DATASTATE;
	private String EXT1;
	private String EXT2;
	private String EXT3;

	public String getID() {
		return ID;
	}
	public String setID() {
		return ID;
	}
	public BigDecimal getPRODINSTID() {
		return PRODINSTID;
	}
	public BigDecimal setPRODINSTID() {
		return PRODINSTID;
	}
	public String getPRODUCTCODE() {
		return PRODUCTCODE;
	}
	public String setPRODUCTCODE() {
		return PRODUCTCODE;
	}
	public String getPRODUCTNAME() {
		return PRODUCTNAME;
	}
	public String setPRODUCTNAME() {
		return PRODUCTNAME;
	}
	public String getSERIALNO() {
		return SERIALNO;
	}
	public String setSERIALNO() {
		return SERIALNO;
	}
	public Integer getUSERID() {
		return USERID;
	}
	public Integer setUSERID() {
		return USERID;
	}
	public BigDecimal get原价格() {
		return 原价格;
	}
	public BigDecimal set原价格() {
		return 原价格;
	}
	public BigDecimal get现在价格() {
		return 现在价格;
	}
	public BigDecimal set现在价格() {
		return 现在价格;
	}
	public Integer getBOXID() {
		return BOXID;
	}
	public Integer setBOXID() {
		return BOXID;
	}
	public BigDecimal get折扣率() {
		return 折扣率;
	}
	public BigDecimal set折扣率() {
		return 折扣率;
	}
	public String getBATCHID() {
		return BATCHID;
	}
	public String setBATCHID() {
		return BATCHID;
	}
	public String getSUPPLIER() {
		return SUPPLIER;
	}
	public String setSUPPLIER() {
		return SUPPLIER;
	}
	public Date getFACTORYDATE() {
		return FACTORYDATE;
	}
	public Date setFACTORYDATE() {
		return FACTORYDATE;
	}
	public Date getVALIDMONTHS() {
		return VALIDMONTHS;
	}
	public Date setVALIDMONTHS() {
		return VALIDMONTHS;
	}
	public String getSTORESTATUS() {
		return STORESTATUS;
	}
	public String setSTORESTATUS() {
		return STORESTATUS;
	}
	public String getSTATUSSTATEREASON() {
		return STATUSSTATEREASON;
	}
	public String setSTATUSSTATEREASON() {
		return STATUSSTATEREASON;
	}
	public String getCREATEOPERID() {
		return CREATEOPERID;
	}
	public String setCREATEOPERID() {
		return CREATEOPERID;
	}
	public String getCREATEORGID() {
		return CREATEORGID;
	}
	public String setCREATEORGID() {
		return CREATEORGID;
	}
	public Date getCREATEDATE() {
		return CREATEDATE;
	}
	public Date setCREATEDATE() {
		return CREATEDATE;
	}
	public String getMODIFYDATE() {
		return MODIFYDATE;
	}
	public String setMODIFYDATE() {
		return MODIFYDATE;
	}
	public Integer getDATASTATE() {
		return DATASTATE;
	}
	public Integer setDATASTATE() {
		return DATASTATE;
	}
	public String getEXT1() {
		return EXT1;
	}
	public String setEXT1() {
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
