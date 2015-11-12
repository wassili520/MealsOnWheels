package com.wassili.mealsonwheels.common.dto;

import java.util.List;

import com.wassili.mealsonwheels.dal.model.Menu;

public class QueryMenuResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3440349137859817575L;
	private Integer recordCount;
	private List<Menu> result;
	
	public Integer getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	public List<Menu> getResult() {
		return result;
	}
	public void setResult(List<Menu> result) {
		this.result = result;
	}
	
	

}
