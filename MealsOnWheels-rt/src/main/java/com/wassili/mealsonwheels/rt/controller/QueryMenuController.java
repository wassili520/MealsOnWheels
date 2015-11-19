package com.wassili.mealsonwheels.rt.controller;

import java.util.LinkedHashMap;
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
import com.wassili.mealsonwheels.common.dto.QueryMenuRequest;
import com.wassili.mealsonwheels.common.dto.QueryMenuResponse;
import com.wassili.mealsonwheels.service.MenuService;
import com.wassili.mealsonwheels.util.MD5SignUtil;
import com.wassili.mealsonwheels.web.constants.BaseConstants;
import com.wassili.mealsonwheels.web.constants.CodeConstants;
import com.wassili.mealsonwheels.web.controller.GenericController;

@Controller
@RequestMapping("menu")
public class QueryMenuController extends
		GenericController<QueryMenuRequest, QueryMenuResponse>{
	
	private static final Logger logger = LoggerFactory.getLogger(QueryMenuController.class);

	
	@Autowired
	private MenuService menuService;
	
	
	@RequestMapping(value="/queryMenu", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public @ResponseBody 
	String queryMenu(@RequestBody QueryMenuRequest request) {
		logger.info("queryMenu request:{}", JSON.toJSONString(request, true));
		
		QueryMenuResponse response = new QueryMenuResponse();
		
		String responseStr = this.invoke(request, response);
		
		logger.info("queryMenu response:{}", responseStr);
		
		return responseStr;
	}


	@Override
	public QueryMenuResponse execute(QueryMenuRequest req,
			QueryMenuResponse resp) {
		try {
			if (validateParam(req, resp)) {
				resp = menuService.queryMenu(req);
			}
		} catch (Exception e) {
			resp.setErrCode(CodeConstants.UNKNOWN_ERROR);
			logger.error("", e);
		}
		return resp;
	}


	@Override
	public void handleCommonRequestParams(QueryMenuRequest req,
			QueryMenuResponse resp) {
		resp.setSignType(req.getSignType());
		
	}


	@Override
	public boolean validateParam(QueryMenuRequest req, QueryMenuResponse resp) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public Map<String, String> getExtendsDataMap(QueryMenuRequest req) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		String secretKey = "aa";
		map.put(BaseConstants.KEY, secretKey);
		String signBody = MD5SignUtil.buildSignBody(req, req, secretKey);
		map.put(BaseConstants.SIGN_BODY, signBody);
		return map;
	}


	@Override
	public String getSecretKey(QueryMenuRequest req) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addResSign(QueryMenuRequest req, QueryMenuResponse res) {
//		String secretKey = "aa";
//		String respSignBody = MD5SignUtil.buildSignBody(res, res, secretKey);
//		res.setSignMsg(MD5SignUtil.getMySignMsg(respSignBody));
	}

	

}
