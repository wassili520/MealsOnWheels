package com.wassili.mealsonwheels.common.dto;

import java.io.Serializable;
import java.util.List;

import com.wassili.mealsonwheels.dal.model.Item;
import com.wassili.mealsonwheels.web.controller.dto.BaseResponse;

public class QueryItemResponse extends BaseResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2979246585722823231L;
	
	private Integer recordCount;
	private List<Item> result;
	
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
