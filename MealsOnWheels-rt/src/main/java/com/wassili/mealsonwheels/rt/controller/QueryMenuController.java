package com.wassili.mealsonwheels.rt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wassili.mealsonwheels.common.dto.QueryMenuRequest;
import com.wassili.mealsonwheels.common.dto.QueryMenuResponse;
import com.wassili.mealsonwheels.service.MenuService;

@Controller
@RequestMapping("menu")
public class QueryMenuController extends
		AbstractController<QueryMenuRequest, QueryMenuResponse>{
	
	private static final Logger logger = LoggerFactory.getLogger(QueryMenuController.class);

	
	@Autowired
	private MenuService menuService;
	
	@Override
	@RequestMapping(value="/queryMenu", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public @ResponseBody 
	String entry(@RequestBody QueryMenuRequest request) {
		logger.info("queryMenu request:{}", JSON.toJSONString(request, true));
		
		QueryMenuResponse response = new QueryMenuResponse();
		
		response = menuService.queryMenu(request);
		
		String respString = this.execute(request, response);
		
		logger.info("queryMenu response:{}", respString);
		
		return respString;
	}

	@Override
	public String handleRequest(QueryMenuRequest request,
			QueryMenuResponse response) {
		return null;
	}

	@Override
	public String handleResponse(QueryMenuRequest request,
			QueryMenuResponse response) {
		return JSON.toJSONString(response, true);
	}


	

}
