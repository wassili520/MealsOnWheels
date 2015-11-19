package com.wassili.mealsonwheels.web.constants;

public class CodeConstants {
	
	/*
    E0001=接口版本不正确
    E0002=字符集不正确
    E0003=接口参数格式不正确
    E0004=签名错误
    E0005=渠道编码不合法
    E0006=签名类型不支持
    E0007=必填参数不能为空
    
    E1001=账号不存在
    E1002=活动不存在
    
    E2001=活动不能重复参与
    E2002=活动未开始或已过期
    E2003=不能消费自己转发的消费码
    E2004=请求过于频繁
    
    E3001=只可以领一次 (即一人同一活动码只可使用一次)
    E3002=消费码错误
    E3003=活动消费码已被领完
    E3004=消费码已过期
    E3005=用户参加活动次数超过最大参加次数
    
    E4001=查询结果集为空
    E4002=报文格式不合法
    E4003=功能号不合法
    
    E0000=未知错误或未定义错误
    */

    public final static String SUCCESS                    = "1";
    public final static String FAILURE                    = "0";

    public final static String INVALID_VERSION            = "E0001";
    public final static String INVALID_INPUTCHARSET       = "E0002";
    public final static String INVALID_PARAM              = "E0003";
    public final static String INVALID_SIGNMSG            = "E0004";
    public final static String INVALID_CLIENTNO           = "E0005";
    public final static String INVALID_SIGN_TYPE          = "E0006";
    public final static String REQUIRED_PARAM_IS_NULL     = "E0007";

    public final static String ACCOUNT_NOT_EXIST          = "E1001";
    public final static String ACTIVITY_NOT_EXIST         = "E1002";

    public final static String ACTIVITY_ACCESS_DUPLICATED = "E2001";
    public final static String ACTIVITY_DATE_INVALID      = "E2002";
    public final static String ACTIVITY_ACCESS_DELAYED    = "E2003";
    public final static String ACTIVITY_REQUEST_FREQUENT  = "E2004";

    public final static String ACTIVITY_RECEIVE_RESTRICT  = "E3001";
    public final static String RECEIVE_CODE_ERROR         = "E3002";
    public final static String ACTIVITY_RECEVIE_COMPLETED = "E3003";
    public final static String RECEIVE_CODE_EXPIRED       = "E3004";
    public final static String RECEIVE_CODE_RECEIVE_COUNT = "E3005";

    public final static String RESULT_IS_NULL             = "E4001";
    public final static String MSG_IS_NOT_LEGAL           = "E4002";
    public final static String INVALID_FUNCTION_NO        = "E4003";

    public final static String UNKNOWN_ERROR              = "E0000";

}
