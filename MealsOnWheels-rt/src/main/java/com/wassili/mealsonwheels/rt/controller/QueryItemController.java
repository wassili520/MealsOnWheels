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
import com.wassili.mealsonwheels.common.dto.QueryItemRequest;
import com.wassili.mealsonwheels.common.dto.QueryItemResponse;
import com.wassili.mealsonwheels.service.ItemService;

@Controller
@RequestMapping("menu")
public class QueryItemController extends
		AbstractController<QueryItemRequest, QueryItemResponse>{

	private static Logger logger = LoggerFactory.getLogger(QueryItemController.class);

	
	@Autowired
	private ItemService itemService;
	
	@Override
	@RequestMapping(value="/queryItem", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public @ResponseBody 
	String entry(@RequestBody QueryItemRequest req) {
		logger.info("queryItem request:{}",JSON.toJSONString(req, true));
		
		QueryItemResponse resp = new QueryItemResponse();
		
		resp = itemService.queryItem(req);
		
		String response = this.execute(req, resp);
		
		logger.info("queryItem response:{}", response);
		
		return response;
	}

	@Override
	public String handleRequest(QueryItemRequest request,
			QueryItemResponse response) {
		return null;
	}

	@Override
	public String handleResponse(QueryItemRequest request,
			QueryItemResponse response) {
		return JSON.toJSONString(response, true);
	}

	
	
}
