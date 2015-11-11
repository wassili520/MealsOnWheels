package com.wassili.mealsonwheels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wassili.mealsonwheels.common.dto.QueryItemRequest;
import com.wassili.mealsonwheels.common.dto.QueryItemResponse;
import com.wassili.mealsonwheels.dal.mapper.ItemMapperExt;
import com.wassili.mealsonwheels.dal.model.Item;

@Service("itemService")
public class ItemService {
	
	@Autowired
	private ItemMapperExt itemMapperExt;
	
	public QueryItemResponse queryItem(QueryItemRequest req) {
		
		Item item = new Item();
		item.setMenuId(req.getMenuId());
		item.setItemType(req.getItemType());
		List<Item> list = itemMapperExt.queryItem(item);
		
		QueryItemResponse response = new QueryItemResponse();
		response.setResult(list);
		response.setRecordCount(list.size());
		
		return response;
	}

}
