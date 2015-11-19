package com.wassili.mealsonwheels.common.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.wassili.mealsonwheels.dal.model.Item;
import com.wassili.mealsonwheels.util.Signaturable;
import com.wassili.mealsonwheels.web.controller.dto.BaseResponse;

public class QueryItemResponse extends BaseResponse implements Serializable, Signaturable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2979246585722823231L;
	
	private Integer recordCount;
	private List<Item> result;
	
	@Override
	public LinkedHashMap<String, String> signParmMap() {
		LinkedHashMap<String, String> paramMap = new LinkedHashMap<String, String>();
		paramMap.put("resultCode", resultCode);
		paramMap.put("signType", signType);
		paramMap.put("errCode", StringUtils.isBlank(errCode) ? "" : errCode);
		paramMap.put("errMsg", StringUtils.isBlank(errMsg) ? "" : errMsg);
		
		
		return paramMap;
	}
	
	public Integer getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	public List<Item> getResult() {
		return result;
	}
	public void setResult(List<Item> result) {
		this.result = result;
	}
	
	

}
