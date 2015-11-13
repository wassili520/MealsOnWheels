package com.wassili.mealsonwheels.web.controller.dto;

/**
 * 
 * @author wassili
 * @version $Id: BaseRequest.java,  
 *
 */
public class BaseRequest {
	
	/**
	 * 接口版本识别号,固定值：1.0
	 */
	protected String version = "1.0";
	
	/**
	 * 字符集,固定选择值：1、2、3,1代表UTF-8;2代表GBK；3代表gb2312,默认值为1
	 */
	protected String inputCharset = "1";
	
	/**
	 * 签名类型,固定值：1,1 代表 MD5 加密签名方式
	 */
	protected String signType = "1";
	
	/**
	 * 签名字符串,以上所有非空参数及其值与密钥组合，经 MD5 加密生成并转化为大写的 32 位字符串
	 */
	protected String signMsg = "";
	
	/**
	 * 渠道，有 PC和MB等
	 */
    protected String channel = "";
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getInputCharset() {
		return inputCharset;
	}

	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSignMsg() {
		return signMsg;
	}

	public void setSignMsg(String signMsg) {
		this.signMsg = signMsg;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}
