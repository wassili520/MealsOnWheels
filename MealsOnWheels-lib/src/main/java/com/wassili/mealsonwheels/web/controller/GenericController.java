package com.wassili.mealsonwheels.web.controller;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wassili.mealsonwheels.web.controller.dto.BaseRequest;
import com.wassili.mealsonwheels.web.controller.dto.BaseResponse;

/**
 * 
 * @author wassili
 * @version $Id: GenericController.java
 *
 * @param <Req>
 * @param <Resp>
 */
public abstract class GenericController<Req extends BaseRequest, Resp extends BaseResponse> {
	
	public abstract Resp execute(Req req, Resp resp);
	
	public abstract void handleCommonRequestParams(Req req, Resp resp);
	
	public abstract boolean validateParam(Req req, Resp resp);
	
	public abstract Map<String, String> getExtendsDataMap(Req req);
	
	public abstract String getSecretKey(Req req);
	
	public abstract void addResSign(Req req, Resp res);
	
	public String invoke(Req req, Resp resp) {

        handleCommonRequestParams(req, resp);
        Map<String, String> extendsDataMap = getExtendsDataMap(req);

        //验证接口参数
        if (handleRequest(req, resp, extendsDataMap)) {
            resp = execute(req, resp);
        }

        //处理返回值
        String respStr = handleResponse(req, resp);
        return respStr;
    }
	
	public boolean handleRequest(Req req, Resp resp, Map<String, String> extendsDataMap) {
		
		return true;
	}
	
	public String handleResponse(Req req, Resp resp) {
		addResSign(req, resp);
		
		return JSON.toJSONString(resp, SerializerFeature.PrettyFormat);
	}

}
