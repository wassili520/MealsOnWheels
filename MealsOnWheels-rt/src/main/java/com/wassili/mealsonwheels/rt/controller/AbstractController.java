package com.wassili.mealsonwheels.rt.controller;

import com.wassili.mealsonwheels.common.dto.BaseRequest;
import com.wassili.mealsonwheels.common.dto.BaseResponse;

public abstract class AbstractController <Request extends BaseRequest, Response extends BaseResponse> {
	
	public abstract String entry(Request req);
	
	public abstract String handleRequest(Request request,Response response);
	
	public String execute(Request request, Response response) {
		return handleResponse(request, response);
	}
	
	public abstract String handleResponse(Request request, Response response);
}
