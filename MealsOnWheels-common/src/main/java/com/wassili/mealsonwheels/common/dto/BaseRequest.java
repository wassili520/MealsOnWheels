package com.wassili.mealsonwheels.common.dto;

import java.io.Serializable;

public class BaseRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2949435655099517061L;
	
	private String cliendId;

	public String getCliendId() {
		return cliendId;
	}

	public void setCliendId(String cliendId) {
		this.cliendId = cliendId;
	}
	
	

}
