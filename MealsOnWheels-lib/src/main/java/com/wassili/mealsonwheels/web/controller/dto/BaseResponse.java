package com.wassili.mealsonwheels.web.controller.dto;

/**
 * 
 * @author wassili
 * @version $Id: BaseResponse.java
 */
public class BaseResponse {
	
	/**
	 * 签名类型,固定值：1,与提交时的签名类型保持一致
	 */
    protected String signType = "1";
    
	/**
	 * 处理结果,00001:账户开通成功，errCode为空,00000:账户开通失败，同时返回相应的errCode
	 */
    protected String resultCode;
    
	/**
	 * 失败时返回的错误代码，可以为空,参考errCode代码表
	 */
    protected String errCode;
    
	/**
	 * ErrCode对应的错误信息
	 */
    protected String errMsg;
    
	/**
	 * 签名字符串,以上所有非空参数及其值与密钥组合，经 MD5 加密生成并转化为大写的 32 位字符串
	 */
    protected String signMsg;
	
	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getSignMsg() {
		return signMsg;
	}
	public void setSignMsg(String signMsg) {
		this.signMsg = signMsg;
	}

	
}
