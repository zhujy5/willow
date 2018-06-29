
package com.nanshan.willow.common.consts;

public class Consts {

	/**
	 * 结果码：成功
	 */
	public static final String RESULT_CODE_SUCCESS = "0";

	public static final String RESULT_CODE_SUCCESS_MSG = "成功";

	public static final Integer RESULT_CODE = 0;

	public static final Integer RESULT_CODE_FAIL = -1;

	/**
	 * 结果码：失败
	 */
	public static final String RESULT_CODE_ERROR = "-1";

	public static final String RESULT_CODE_ERROR_MSG = "失败";

	public static final String RESULT_CODE_CONNECT_ERROR = "99";

	public static final String RESULT_CODE_CONNECT_ERROR_MSG = "通讯异常";

	public static final String RESULT_CODE_SYSTEM_ERROR = "9999";

	public static final String RESULT_CODE_SYSTEM_ERROR_MSG = "未知的系统异常";

	public static final String RESULT_CODE_PAY_FAIL_MSG="支付失败";

	// 权限不足：token解析uuid与用户uuid不一致
	public static final String RESULT_CODE_UUID_ERROR = "-4";

	public static final String RESULT_MSG_UUID_ERROE = "权限不足：token解析uuid与用户uuid不一致";

	//快付通商户异常
	public static final String RESULT_MSG_MERCHANT_ERROR = "二级商户Id为空";

	// wxopenid已经绑定 数据重复
	public static final String RESULT_CODE_MSG_REPEAT = "-5";

	public static final String RESULT_CODE_PAY_CONNECT_ERR = "1009"; //网关返回code 请求未成功
	public static final String RESULT_CODE_TRADE_CREATED_FAIL = "1010"; //支付下单失败
	//暂不开启支付宝支付
	public static final String RESULT_CODE_NO_OPEN_ALIPAY = "1011";

	//参数校验失败
	public static final String RESULT_CODE_NOTITY_PARAM_FAIL = "1004";
	//用户secretId校验失败
	public static final String RESULT_CODE_NOTITY_SECRETID_FAIL = "1005";
	//身份认证失败
	public static final String RESULT_CODE_NOTITY_AUTH_FAIL = "1006";
	//鉴权失败
	public static final String RESULT_CODE_NOTITY_ROLE_FAIL = "1007";
	//重放攻击
	public static final String RESULT_CODE_NOTITY_ATTACK_FAIL = "1008";
	
	//该用户没有注册
	public static final String RESULT_CODE_USER_NO_REGISTER = "1009";
	
	//获取openid失败
	public static final String RESULT_CODE_GET_OPENID_FAIL = "auth_1009";
	
	//微信未绑定
	public static final String RESULT_CODE_WX_UNBINDING = "unbinding_1012";
	//unbinding_1012
	// 短信验证结果
	public static final String RESULT_CODE_SMS_ERROR = "-9999";

	/**
	 * 结果码：没有数据
	 */
	public static final String RESULT_CODE_NO_RECORD = "-2";

	public static final String RESULT_CODE_NO_RECORD_MSG = "暂无记录";

	public static final String RESULT_CODE_MSG_NULL = "参数不合法";

	/**
	 * 查询交易结果 0 成功 1异常 2第三方支付成功，钱包未成功
	 */
	public static final String TRADE_QUERY_STATUS_FAIL = "1";

	public static final String TRADE_QUERY_STATUS_ISCONFIRM = "2";
	/**
	 * 结果码:验证码验证失败
	 */
	public static final String RESULT_VERIFICA_CODE_ERROR = "-3";

	// 系统全局配置文件
	public static final String SYSTEM_GLOBAL_PROPERTIES = "system.properties";

	// 是否发送短信 0 发送了 1未成功发送
	public static final String MOVE_CAR_IS_SEND_MESSAGE_SUCCESS = "0";

	public static final String MOVE_CAR_IS_SEND_MESSAGE_FAIL = "1";

	// 用户密码状态 1 锁定
	public static final String USER_PASSWOED_STATUS = "1";

	// 用户账号状态 1锁定
	public static final String USER_USERACCOUNT_STATUS = "1";

	// 用户注册类别
	public static final String USER_REGISTER_TYPE_APP = "0";

	public static final String USER_REGISTER_TYPE_WX = "1";

	public static final String USER_REGISTER_TYPE_ALL = "2";

	// 短信验证码类型 0 注册获取 1忘记密码获取
	public static final String VERIFICA_CODE_TYPE_FORGET = "1";

	// CarRelatedService里面需要的标识
	public static final String CARRELATED_ONE_REGISTER = "0";

	public static final String CARRELATED_SUCESS_REGISTER = "0";

	public static final String CARRELATED_FAIL_REGISTER = "-1";

	public static final String CARRELATED_OCCUPY_REGISTER = "-2"; //已被绑

	public static final String CARRELATED_UNMATCHED_REGISTER = "-3";// 不匹配的
	//UserRelevantController里面特有的
	public static final String JS_FAIL_CODE = "-11";// 不匹配的
	public static final String SESSION_USER = "sessionUser";

	// token redis 过期时间
	public static final Long REDIS_TOKEN_EXPIRE_TIME = 604800L;

	public static final Long REDIS_TOKEN_WXOPENID_EXPIRE_TIME = 2419200L;

	//单测过期时间
	public static final Long REDIS_TOKEN_EXPIRE_TIME_TEST = 60L;

	// 短信过期时间
	public static final Long REDIS_CODE_EXPIRE_TIME = 300L;

	//短信限制
	public static final String REDIS_SMS_IP_NUM = "100";

	public static final Long REDIS_SMS_IP_TIME = 600L;

	public static final String REDIS_SMS_USER_NUM = "5";

	public static final Long REDIS_SMS_USER_TIME = 60L;
	//默认次数
	public static final String REDIS_SMS_NUM = "1";

	public static final String RESCODE = "resultCode";

	public static final String RESMSG = "resultMsg";

	// 认证开关 0需要认证 1不需要认证
	public static final String AUTH_TOKEN_CFG = "1";

	// ============redis key==============
	// app登陆验证码
	public static final String REDIS_LOGIN_APP_KEY = "bbpark_core:login:0:";

	// 微信登录验证码
	public static final String REDIS_LOGIN_WX_KEY = "bbpark_core:login:1:";

	// 忘记密码验证码
	public static final String REDIS_FORGET_KEY = "bbpark_core:forget:";

	//短信黑名单
	public static final String REDIS_SMS_BLACK_KEY = "bbpark_core:sms:black:";

	//短信开关设置 0验证 1不验证
	//ip限制
	public static final String SMS_IP_CFG = "1";
	//用户限制
	public static final String SMS_USER_CFG = "1";

	//修改密码验证码
	public static final String CHANGE_PHONE_KEY = "bbpark_core:change:";
	// token
	public static final String REDIS_AUTH_KEY = "bbpark_core:token:";

	public static final String PARKLOT_NAME_CODE = "parklot.name.code";
    public static final String BBPARK_CLIENT_SCAN = "wx_scan";

	//微信openid关联id
	public static final String REDIS_WX_OPENID_RELEVANCE_KEY = "bbpark_core:wxrelevanceid:";
	// ==================================================
	// 请求类型 app wx
	public static final String TOKEN_CLIENT_TYPE_APP = "0:";

	public static final String TOKEN_CLIENT_TYPE_WX = "1:";

	public static final String TOKEN_CLIENT_TYPE_SYS = "2:";

	public static final String TOKEN_CLIENT_TYPE_SYS_ROLE = "3:";

	// 请求类型 app wx
	public static final String Willow_CLIENT_TYPE_APP = "0";

	public static final String BBPARK_CLIENT_TYPE_WX = "1";

	public static final String BBPARK_CLIENT_TYPE_SYS = "2";

	//请求头类型
	public static final String BBPARK_CLIENT_IOS = "ios";
	public static final String BBPARK_CLIENT_ANDROID = "android";
	public static final String BBPARK_CLIENT_WX = "wx";

	// ==================jvm缓存key==========================
	public static final String AUTH_TOKEN_ROLE_KEY = "bbpark_core_auth_role";

	public static final String AUTH_TOKEN_SYS_ROLE_KEY = "bbpark_core_auth_sys_role";

	public static final String Willow_CORE_SYS_CONFIG = "willow_core_sys_config";

	public static final String BBPARK_CORE_PARKLOT_CONFIG = "bbpark_core_parklot_config";


	//微信配置
	public static final String BBPARK_CORE_WXPAY_CONFIG = "bbpark_core_wxpay_config";
	//支付宝配置
	public static final String BBPARK_CORE_ALIPAY_CONFIG = "bbpark_core_alipay_config";
	//快付通配置
	public static final String BBPARK_CORE_KPPPAY_CONFIG = "bbpark_core_kpppay_config";
	//白名单
	public static final String BBPARK_CORE_AUTH_WHITELIST = "bbpark_core_auth_whitelist";
	//app版本
	public static final String BBPARK_CORE_APP_VERSION = "bbpark_core_app_version";
	//app角色菜单权限
	public static final String BBPARK_CORE_APP_ROLE_MENU = "bbpark_core_app_menu";
	//支付宝支付私钥key
	public static final String SERVER_ALIPAY_PRIVATE_KEY = "server_alipay_private_key";

	// 缓存管理
	public static final String BBPARK_CORE_CACHE_MAP_KEY = "bbpark_core_cache_map_key";

	//一级菜单
	public static final String BBPARK_CORE_APP_PARENT_MENU = "#";

	//未登陆用户角色
	public static final String BBPARK_CORE_APP_ROLE_OPEM = "open";

	//=======================jvm缓存可以 完=========================

	//版本是否升级 0升级 1不升级
	public static final String BBPARK_CORE_APP_VERSION_YES = "0";

	public static final String BBPARK_CORE_APP_VERSION_NO = "1";


	//接口参数
	//支付类型 0充值
	public static final String WXPAY_TYPE_RECHARGE = "0";
	//支付类型  1 支出 停车缴费
	public static final String WXPAY_TYPE_CAR_COST = "1";
	//支付类型 2 支出 月卡缴费
	public static final String WXPAY_TYPE_MONTH_COST = "2";
	//退款标识
	public static final String PAY_TRADE_REFUND = "3";
	//用户钱包记录
	//1充值
	public static final String USER_WALLET_STATUS_RECHARGE = "1";
	//2支出
	public static final String USER_WALLET_STATUS_COST = "0";

	//支付类型 1微信
	public static final String USER_PAY_TYPE_WX = "1";
	//支付类型  0 支付宝
	public static final String USER_PAY_TYPE_ZFB  = "0";
	//支付类型  2 快付通
	public static final String USER_PAY_TYPE_KFT  = "2";

	//停车缴费
	public static final String COST_TYPE_PARKING = "0";
	//月卡充值
	public static final String COST_TYPE_MONTHCARD = "1";

	//调第三方开闸入参
	//微信支付
	public static final String COST_THIRD_PARTY_WX = "02";
	//支付宝
	public static final String COST_THIRD_PARTY_ZFB = "03";

	//退款成功
	public static final String WXPAY_REFUND_STATUS_SUCCESS = "1";
	//是否调用核心core短信服务 false不调用
	public static final String SERVER_SMS_CALL_CORE = "false";

	//是否启用快付通 true 启用
	public static final String IS_USE_KFTPAY = "true";

	//支付订单状态 0未支付 2支付成功
	public static final String ORDER_PAY_SUCCESS = "2";

	public static final String ORDER_PAY_FAIL = "0";

	public static final String ORDER_PAY_IS_CONFIRM = "1";

	//退款订单状态 0申请退款 1退款确认中 2退款成功 3退款失败 4退款异常
	public static final String REFUND_ORDER_IS_CONFIRM = "1";
	public static final String REFUND_ORDER_SUCCESS = "2";
	public static final String REFUND_ORDER_FAIL = "3";
	public static final String REFUND_ORDER_EXEC = "4";
	//是否使用快付通预支付
	public static final String IS_USER_KFT_PREPAY_NO = "1";
	public static final String IS_USER_KFT_PREPAY_YES = "2";

	//停车缴费支付订单金额0
	public static final String TRADE_MONEY_ZERO = "0";

	/****SFTP配置*/
	public static final String SERVER_KPP_FTPHOST = "server.kpp.ftphost";
	public static final String SERVER_KPP_FTPUSERNAME = "server.kpp.ftpusername";
	public static final String SERVER_KPP_FTPPASSWORD = "server.kpp.ftppassword";
	public static final String SERVER_KPP_FTPPORT = "server.kpp.ftpport";
	public static final String SERVER_KPP_DOWN_LOCALPATH = "server.kpp.down.localpath";
	/**
	 * 第三方充值返回结果吗
	 */
	public static final String THIRDPART_GETACCESSURL_SUCCESS = "0";//获得访问第三方的URL成功
	public static final String THIRDPART_GETACCESSURL_FAIL = "-1";//获得访问第三方的URL失败
	public static final String THIRDPART_RECHAGE_SUCCESS = "1";//充值成功
	public static final String THIRDPART_RECHAGE_FAIL = "0";//充值失败
	public static final String THIRDPART_SIGNATURE_CHECK_FAIL = "2";//验签失败
	public static final String THIRDPART_RECHAGE_ERROR = "-1";//充值错误

	/**
	 * 定时器任务
	 */
	public static final String TIMMER_TASKS = "timmer_tasks";//获得访问第三方的URL成功
	/*
	 * 批处理状态标记
	 */
	public static final String TIMMER_TYPE_BATCH="0";
	public static final String TIMMER_TYPE_MANUAL="1";
	public static final String TIMMER_OPERATOR_SUCCESS="0";
	public static final String TIMMER_OPERATOR_FAIL="1";

	//无牌车出入场返回
	public static final String RETURN_CODE_INPARK_SUCCESS = "1000"; //下发成功
	public static final String RETURN_CODE_INPARK_AGAIN = "1001"; //此凭证已入场
	public static final String RETURN_CODE_OUTPARK_SUCCESS = "1002"; //此凭证已出场
	public static final String RETURN_CODE_PAY_SUCCESS = "1003"; // 此凭证已缴费
	public static final String RETURN_CODE_NO_MATCH = "1004"; //未匹配（超时未检测到车辆压地感）
	public static final String RETURN_CODE_NO_PAY = "1005"; // 该车尚未缴费
	public static final String RETURN_CODE_OPEN = "1006"; //开闸成功
	//无牌车创建订单返回
	public static final String RETURN_CODE_CREATE_ORDER_SUCCESS = "0"; //创建订单成功
	public static final String RETURN_CODE_CREATE_NOT_PARK = "1002"; //非临时卡
	public static final String RETURN_CODE_CREATE_ORDER_MONTH = "1004"; //非临时卡
	public static final String RETURN_CODE_CREATE_ORDER_OVERTIME = "1006"; //超时滞留时间内
	public static final String RETURN_CODE_CREATE_ORDER_FREE = "1007"; //正常免费时间
	public static final String RETURN_CODE_CREATE_ORDER_REDUCTION = "1008"; //打折减免时间
	public static final String RETURN_CODE_CREATE_ORDER_ALLFREE = "1009"; //打折全免
	public static final String RETURN_CODE_CREATE_ORDER_ZERO = "1010"; //混合打折收费0元
	public static final String RETURN_CODE_CREATE_ORDER_UNKNOWN_EXEC = "9999"; //其他未知的错误

	//订单来源
	public static final String ORDER_ORIGIN_NOPLATENUMBER_CAR = "7"; //订单来源 （无牌车）
	//9-已缴费，超时滞留时间内
	public static final String CREATE_ORDER_OVERTIME = "9";
	//是否开启无牌车
	public static final String IS_DOWN_CAR_CERTIFICATE = "true";
	
	//优惠券类型
	//满减卷
	public static final String COUPON_TYPE_REDUCTION = "0";
	//折扣卷
	public static final String COUPON_TYPE_DISCOUNT = "1";
	//抵用卷
	public static final String COUPON_TYPE_DEDUCTIBLE = "2";
	//是否使用优惠券
	//1使用
	public static final String COUPON_IS_USE_YES = "1";
	// 0 否
	public static final String COUPON_IS_USE_NO = "0";
	//从redis根据wxrelevanceId获取wxOpenId 
	public static final String AUTH_WX_OPEN_ID = "wxOpenId";
	
	
	
	 /**
     * 预授权模块
     */
    //预授权开关
    public static final String SERVER_PREAUTH_SWITCH = "server.preauth.switch";
    //预授权开关打开标识
    public static final String SERVER_PREAUTH_SWITCH_OPEN = "0";
    
    public static final String IS_PREAUTH_ORDER_KEY="isPreAuthOrder";
    public static final String PREAUTH_ORDER_MESSAGE_KEY="preAuthOrderMsg";
    public static final String PREAUTH_UUID="preAuthUUID";

    public static final String IS_PREAUTH_ORDER = "0";
    public static final String NOTIS_PREAUTH_ORDER = "1";

    
	
	
	
	
}
