package com.nanshan.willow.common.consts;

import java.util.HashMap;
import java.util.Map;

public class ResultCodes {
	/***
	 * 由两部分组成,后台开发请把各自模块分开
	 * 1.错误编码 五位数字 
	 * 月卡模块 10开头
	 * 
	 * 
	 * 
	 * 2.错误代码的描述
	 */

	public static Map<String, String> paramMap = new HashMap<String, String>();// 装错误代码的信息描述的map

	/** 模块通用的编码 */
	public static final String RESULT_CODE_SUCCESS = "0"; // 成功
	public static final String RESULT_CODE_ERROR = "-1"; // 失败
	
	
	
	/**月卡模块 用10做开头,命名规范， 模块名+代码大概描述,如 MONTHCARD_TOKEN_INVALID (月卡+token失效) */
	public static final String MONTHCARD_INTERMEDIATE_PLATFORM_PROBLEMS = "10011"; // 中间平台代码出问题
	public static final String MONTHCARD_TOKEN_INVALID = "10012"; // 可能是token出问题
	public static final String MONTHCARD_FEE_SCALE_DEFECT = "10013";// 暂无收费标准,或者是收费标准出问题
	public static final String MONTHCARD_EXPIRATION_DATE_DEFEC = "10014";// 月卡无到期日期
	public static final String MONTHCARD_UPDATE_DATE_FAIL = "10015";// 月卡更新日期失败
	public static final String MONTHCARD_JSRETURN_DATA_EMPTY = "10016";// 捷顺返回的信息中月卡数据是空的
	public static final String MONTHCARD_CONSIDER_PLATFORM_PROBLEM = "10017";// bbpark_core_server这边数据正常，从捷顺返回数据为null,考虑中间平台出问题
	public static final String MONTHCARD_JS_DATA_ACCURACY = "10018";// js返回月卡信息为空，考虑数据我方输入是否正确，js数据是否被删除
	public static final String MONTHCARD_INSERT_DATA_FAIL = "10019";//bbpark_core_server插入月卡数据失败
	public static final String MONTHCARD_JS_REFUSE_RECHARGE = "10020";//bbpark_core_server代码没问题，捷顺那边月卡不能充值，(可能是延期导致)
    public static final String MONTHCARD_CARRELATED_OCCUPY_REGISTER = "10021";//月卡已被绑定
    public static final String MONTHCARD_PAY_TYPE_DEFECT = "10022";//支付类型为空
    public static final String MONTHCARD_BE_OVERDUE  = "10023";//月卡已过期
    public static final String MONTHCARD_BE_OVERDUE_TOLONG  = "10024";//月卡过期时间过长
 
    
    /**车辆模块  用11开头*/
	public static final String CAR_OCCUPY_REGISTER = "11011"; //车辆已被绑定
	
    //无牌车凭证 12开头
	//无牌车请求异常
    public static final String UNLICENSED_CAR_INPARK_SUCCESS = "12000"; //下发成功 
    public static final String UNLICENSED_CAR_INPARK_AGAIN = "12001"; //此凭证已入场
    public static final String UNLICENSED_CAR_OUTPARK_SUCCESS = "12002"; //此凭证已出场
    public static final String UNLICENSED_CAR_PAY_SUCCESS = "12003"; // 此凭证已缴费
    public static final String UNLICENSED_CAR_NO_MATCH = "12004"; //未匹配
    public static final String UNLICENSED_CAR_NO_PAY = "12005"; //该车尚未缴费
    
    
    /** 错误代码的描述 */
	static {
		/**月卡模块 */
		paramMap.put(MONTHCARD_INTERMEDIATE_PLATFORM_PROBLEMS, "中间平台代码出问题");
		paramMap.put(MONTHCARD_TOKEN_INVALID, "可能是token出问题");
		paramMap.put(MONTHCARD_FEE_SCALE_DEFECT, "暂无收费标准");
		paramMap.put(MONTHCARD_EXPIRATION_DATE_DEFEC, "月卡无到期日期");
		paramMap.put(MONTHCARD_UPDATE_DATE_FAIL, "月卡更新日期失败");
		paramMap.put(MONTHCARD_JSRETURN_DATA_EMPTY, "捷顺返回的信息中月卡数据是空的");
		paramMap.put(MONTHCARD_CONSIDER_PLATFORM_PROBLEM,"bbpark_core_server这边数据正常，从捷顺返回数据为null 考虑中间平台出问题");
		paramMap.put(MONTHCARD_CONSIDER_PLATFORM_PROBLEM,"js返回月卡信息为空，考虑数据我方输入是否正确，js数据是否被删除");
		paramMap.put(MONTHCARD_INSERT_DATA_FAIL, "bbpark_core_server插入月卡数据失败");
		paramMap.put(MONTHCARD_JS_REFUSE_RECHARGE, "bbpark_core_server代码没问题，捷顺那边月卡不能充值，(可能是延期导致)");
		paramMap.put(MONTHCARD_CARRELATED_OCCUPY_REGISTER, "月卡已被绑定");
		paramMap.put(MONTHCARD_PAY_TYPE_DEFECT, "支付类型为空");
		paramMap.put(MONTHCARD_BE_OVERDUE, "月卡已过期，请联系物业");

		

		/*******************************************/
		/***车辆模块*/
		paramMap.put(CAR_OCCUPY_REGISTER, "车辆已被绑定");

		
		
	}

}
