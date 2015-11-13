package com.wassili.mealsonwheels.common.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.wassili.mealsonwheels.util.Signaturable;
import com.wassili.mealsonwheels.web.controller.dto.BaseRequest;

public class QueryItemRequest extends BaseRequest implements Serializable, Signaturable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2548529744407122657L;
	
	private Integer menuId;
	private Integer itemType;
	
	@Override
	public LinkedHashMap<String, String> signParmMap() {
		LinkedHashMap<String, String> paramMap = new LinkedHashMap<String, String>();
		paramMap.put("version", version);
		paramMap.put("inputCharset", inputCharset);
		paramMap.put("signType", signType);
		paramMap.put("channel", channel);
		
		paramMap.put("menuId", menuId.toString());
		paramMap.put("itemType", itemType.toString());

		return paramMap;
	}

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
