package com.employee.management.dto;

/**
 * Error class for exception handling.
 * @author arathynair
 *
 */
public class Error {
	private Integer errorCode;
	private String errorMsg;
	
	public Error() {
		super();
	}
	
	public Error(Integer errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}


	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
}
