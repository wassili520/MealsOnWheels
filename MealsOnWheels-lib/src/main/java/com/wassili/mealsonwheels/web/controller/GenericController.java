package com.wassili.mealsonwheels.web.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wassili.mealsonwheels.util.MD5SignUtil;
import com.wassili.mealsonwheels.web.constants.BaseConstants;
import com.wassili.mealsonwheels.web.constants.CodeConstants;
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
		String secretKey = extendsDataMap.get(BaseConstants.KEY);
		if (StringUtils.isBlank(secretKey)) {
			resp.setErrCode(CodeConstants.INVALID_CLIENTNO);
			return false;
		}
		
		String signBody = extendsDataMap.get(BaseConstants.SIGN_BODY);
		String mySignMsg = MD5SignUtil.getMySignMsg(signBody);
		if (!MD5SignUtil.verifySign(mySignMsg, req.getSignMsg())) {
			resp.setErrCode(CodeConstants.INVALID_SIGNMSG);
			return false;
		}
		
		if (StringUtils.isBlank(req.getVersion())
		    || !BaseConstants.DEFAULT_VERSION.equals(req.getVersion().trim())) {
            resp.setErrCode(CodeConstants.INVALID_VERSION);
            return false;
        }

        if (StringUtils.isBlank(req.getInputCharset())
            || !BaseConstants.DEFAULT_INPUT_CHARSET.equals(req.getInputCharset().trim())) {
            resp.setErrCode(CodeConstants.INVALID_INPUTCHARSET);
            return false;
        }

        if (StringUtils.isBlank(req.getSignType())
            || !BaseConstants.DEFAULT_SIGN_TYPE.equals(req.getSignType().trim())) {
            resp.setErrCode(CodeConstants.INVALID_SIGN_TYPE);
            return false;
        }
		
		return true;
	}
	
	public String handleResponse(Req req, Resp resp) {
		
		if (StringUtils.isBlank(resp.getErrCode())) {
			resp.setResultCode(CodeConstants.SUCCESS);
		} else {
			resp.setResultCode(CodeConstants.FAILURE);
			if (StringUtils.isBlank(resp.getErrMsg())) {
//				resp.setErrMsg(codere);
			}
		}
		
		addResSign(req, resp);
		
		return JSON.toJSONString(resp, SerializerFeature.PrettyFormat);
	}

}
