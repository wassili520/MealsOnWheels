package com.wassili.mealsonwheels.web.controller.dto;

/**
 * 
 * @author wassili
 * @version $Id: BaseResponse.java
 */
public class BaseResponse {
	
	private String code;
	private String message;
	
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
