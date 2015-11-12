package com.wassili.mealsonwheels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wassili.mealsonwheels.common.dto.QueryMenuRequest;
import com.wassili.mealsonwheels.common.dto.QueryMenuResponse;
import com.wassili.mealsonwheels.dal.mapper.MenuMapperExt;
import com.wassili.mealsonwheels.dal.model.Menu;

@Service("menuService")
public class MenuService {
	
	@Autowired
	private MenuMapperExt menuMapperExt;
	
	public QueryMenuResponse queryMenu(QueryMenuRequest request) {
		List<Menu> list = menuMapperExt.queryMenu();
		
		QueryMenuResponse response = new QueryMenuResponse();
		response.setResult(list);
		response.setRecordCount(list.size());
		
		return response;
	}
}
