package com.wassili.mealsonwheels.rt.controller;

import java.util.Map;

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
import com.wassili.mealsonwheels.web.controller.GenericController;

@Controller
@RequestMapping("menu")
public class QueryItemController extends
		GenericController<QueryItemRequest, QueryItemResponse>{

	private static Logger logger = LoggerFactory.getLogger(QueryItemController.class);

	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping(value="/queryItem", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public @ResponseBody 
	String queryItem(@RequestBody QueryItemRequest req) {
		logger.info("queryItem request:{}",JSON.toJSONString(req, true));
		
		QueryItemResponse resp = new QueryItemResponse();
		
		String responseStr = this.invoke(req, resp);
		
		logger.info("queryItem response:{}", responseStr);
		
		return responseStr;
	}

	@Override
	public QueryItemResponse execute(QueryItemRequest req,
			QueryItemResponse resp) {
		try {
			if (validateParam(req, resp)) {
				resp = itemService.queryItem(req);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resp;
	}

	@Override
	public void handleCommonRequestParams(QueryItemRequest req,
			QueryItemResponse resp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateParam(QueryItemRequest req, QueryItemResponse resp) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, String> getExtendsDataMap(QueryItemRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSecretKey(QueryItemRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addResSign(QueryItemRequest req, QueryItemResponse res) {
		// TODO Auto-generated method stub
		
	}

	
	
}
