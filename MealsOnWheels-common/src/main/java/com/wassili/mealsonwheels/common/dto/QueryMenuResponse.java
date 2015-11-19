package com.wassili.mealsonwheels.common.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.wassili.mealsonwheels.dal.model.Menu;
import com.wassili.mealsonwheels.util.Signaturable;
import com.wassili.mealsonwheels.web.controller.dto.BaseResponse;

public class QueryMenuResponse extends BaseResponse implements Signaturable,Serializable{

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
	@Override
	public LinkedHashMap<String, String> signParmMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
