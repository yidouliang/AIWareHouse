package com.boot.security.server.advice;

import com.alipay.api.AlipayApiException;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.boot.security.server.dto.ResponseInfo;

import java.util.List;

/**
 * springmvc异常处理
 * 
 * @author hebh
 *
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@ExceptionHandler({ IllegalArgumentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseInfo badRequestException(IllegalArgumentException exception) {
		return new ResponseInfo(HttpStatus.BAD_REQUEST.value() + "", exception.getMessage());
	}

	@ExceptionHandler({ AccessDeniedException.class })
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseInfo badRequestException(AccessDeniedException exception) {
		return new ResponseInfo(HttpStatus.FORBIDDEN.value() + "", exception.getMessage());
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class, HttpMessageNotReadableException.class,
			UnsatisfiedServletRequestParameterException.class, MethodArgumentTypeMismatchException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseInfo badRequestException(Exception exception) {
		return new ResponseInfo(HttpStatus.BAD_REQUEST.value() + "", exception.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseInfo handleBindException(MethodArgumentNotValidException ex) {
		FieldError fieldError = ex.getBindingResult().getFieldError();
		log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
		ResponseInfo responseInfo = new ResponseInfo(SystemStatusEnum.BIND_ERROR.getCode(),fieldError.getDefaultMessage());
		return responseInfo;
	}


	@ExceptionHandler(BindException.class)
	public ResponseInfo handleBindException(BindException ex) {
		//校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
		FieldError fieldError = ex.getBindingResult().getFieldError();
		log.info("必填校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
		ResponseInfo responseInfo = new ResponseInfo(SystemStatusEnum.BIND_ERROR.getCode(),fieldError.getDefaultMessage());
		return responseInfo;
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseInfo exception(Throwable throwable) {
		log.error("系统异常", throwable);
		return new ResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.value() + "", throwable.getMessage());

	}

	@ExceptionHandler(AlipayApiException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseInfo alipayApiException(AlipayApiException e) {
		log.error("支付宝接口异常", e);
		return new ResponseInfo(e.getErrCode() + "", e.getMessage());
	}

	@ExceptionHandler(SystemException.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseInfo systemException(SystemException systemException) {
		return new ResponseInfo(systemException.getCode(), systemException.getMessage());
	}


}
