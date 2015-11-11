package com.wassili.mealsonwheels.common.dto;

import java.io.Serializable;

public class BaseResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6180576107323159651L;
	
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
