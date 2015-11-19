package com.wassili.mealsonwheels.util;

import java.util.LinkedHashMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class MD5SignUtil {
	
	private static final Log logger = LogFactory.getLog(MD5SignUtil.class);
	
	/**
     * 按键值对把参数key=value增加到buf对象中.
     * 如果为空则不增加.
     * 
     * @param buf StringBuffer
     * @param key String
     * @param value String
     */
	public static void appendSignParameter(final StringBuffer buf, final String key,
            final String value) {
		appendSignParameter(buf, key, value, true);
	}
	
	/**
     * 按键值对把参数key=value增加到buf对象中.
     * 如果为空则不增加.
     * 
     * @param buf StringBuffer
     * @param key String
     * @param value String
     * @param appendAndChar boolean
     */
    public static void appendSignParameter(final StringBuffer buf, final String key,
                                           final String value, final boolean appendAndChar) {
    	appendSignParameter(buf, key, value, appendAndChar, false);
    }
    
    /**
     * 按键值对把参数key=value增加到buf对象中.
     * 如果为空则不增加.
     * 
     * @param buf StringBuffer
     * @param key String
     * @param value String
     * @param appendAndChar boolean
     * @param containEmptyStr boolean
     */
    public static void appendSignParameter(final StringBuffer buf, final String key,
                                           final String value, final boolean appendAndChar,
                                           final boolean containEmptyStr) {
    	if (!containEmptyStr && StringUtils.isEmpty(value)) {
			return;
		} else {
			buf.append(key).append(":").append(null == value ? "" :value);
			if (appendAndChar) {
				buf.append(",");
			}
		}
    }
	
	public static String buildSignBody(Object pojo, Signaturable sign, String key) {
		if (sign == null) {
			return null;
		}
		LinkedHashMap<String, String> signaureParamMap = sign.signParmMap();
		if (signaureParamMap == null) {
			return null;
		}
		StringBuffer buf = new StringBuffer();
		
		for (String paramName : signaureParamMap.keySet()) {
			String paramValue = signaureParamMap.get(paramName);
			if (paramValue != null) {
				MD5SignUtil.appendSignParameter(buf, paramName, paramValue);
			}
		}
		
		MD5SignUtil.appendSignParameter(buf, "key", key, false);
		
		if (logger.isDebugEnabled()) {
			logger.debug("signBody: " + buf.toString());
		}
		
		return buf.toString();
	}
	
	/**
	 * 获取加密串
	 * @param signBody
	 * @return
	 */
	public static String getMySignMsg(String signBody) {
		String digest = DigestUtils.md5Hex(signBody);
		if (logger.isDebugEnabled()) {
            logger.debug("MD5值: {}, MD5签名要素: {}" + digest + signBody);
        }
		return digest;
	}
	
	public static boolean verifySign(String mySignMsg, String yourSignMsg) {
		System.out.println("mySignMsg:" + mySignMsg + " yourSignMsg:" +yourSignMsg);
		return StringUtils.defaultIfEmpty(mySignMsg, "").equals(yourSignMsg);
	}
}
