package com.wassili.mealsonwheels.util;

import java.util.LinkedHashMap;

/**
 * 验签接口，对实现该接口的请求bean进行验签
 * @author Administrator
 *
 */
public interface Signaturable {
	
	public LinkedHashMap<String, String> signParmMap();
}
