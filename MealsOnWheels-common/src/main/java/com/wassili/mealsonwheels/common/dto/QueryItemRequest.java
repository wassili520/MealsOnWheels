package com.wassili.mealsonwheels.common.dto;

import java.io.Serializable;

import com.wassili.mealsonwheels.web.controller.dto.BaseRequest;

public class QueryItemRequest extends BaseRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2548529744407122657L;
	
	private Integer menuId;
	private Integer itemType;
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getItemType() {
		return itemType;
	}
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	
	

}
