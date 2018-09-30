package com.boot.security.server.dto;

import com.boot.security.server.enums.SystemStatusEnum;

import java.io.Serializable;

public class ResponseInfo implements Serializable {

	private static final long serialVersionUID = -4417715614021482064L;

	private String code;
	private String message;

	public ResponseInfo(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ResponseInfo(SystemStatusEnum systemStatusEnum) {
		super();
		this.code = systemStatusEnum.getCode();
		this.message = systemStatusEnum.getMessage();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
