package com.wassili.mealsonwheels.common.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.wassili.mealsonwheels.util.Signaturable;
import com.wassili.mealsonwheels.web.controller.dto.BaseRequest;

public class QueryMenuRequest extends BaseRequest implements Signaturable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2181030740728501330L;

	@Override
	public LinkedHashMap<String, String> signParmMap() {
		LinkedHashMap<String, String> paramMap = new LinkedHashMap<String, String>();
		paramMap.put("version", version);
		paramMap.put("inputCharset", inputCharset);
		paramMap.put("signType", signType);
		paramMap.put("channel", channel);
		
		
		return paramMap;
	}
	
}
