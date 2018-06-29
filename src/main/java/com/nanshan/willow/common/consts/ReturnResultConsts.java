package com.nanshan.willow.common.consts;

/**   
 * @ClassName: ReturnResultConsts.java 
 * @Description: 常用返回结果汇总
 * @author  huangzb001   
 * @date 2017年11月17日 上午11:39:57 
 * @version V1.0   
*/
public enum ReturnResultConsts {
	SIGNATURE_FAIL ("-2","验签失败！"),
	RECHAGE_SUCCESS ("0","充值成功！"),
	RECHAGE_FAIL("-1","充值失败！"),
	RECHAGE_QUERY_SUCCESS ("0","订单充值成功！"),
	RECHAGE_QUERY_FAIL("-1","订单充值失败！"),
	PARAMETER_MISSING ("-1","请求参数缺失"),
	QHINS_REQUEST_PARAMETER_MISSING("-6","请求参数缺失"),
	PARAMETER_MATCHING_ERROR ("-1","请求参数匹配错误"),
	REQUEST_OVERTIME ("-5","请求时间不在当前5分钟之内"),
	RECHAGE_EXCEPTION("-3","充值异常"),
	RECHAGE_QUERY_EXCEPTION("-3","订单充值查询异常"),
	RECHAGE_ORDER_EXIST ("-4","该订单已存在"),
	URL_GENERATE_EXCEPTION ("-3","URL生成异常"),
	QHINS_URL_GENERATE_ERROR ("-1","财险广告访问url生成错误"),
	QHINS_URL_GENERATE_SUCCESS ("0","财险广告访问url生成成功"),
	QHINS_URL_GENERATE_EXCEPTION ("-3","财险广告访问url生成异常"),
	/**
	 *广告后台管理返回常量
	 */
	ADVERTISTMENT_ADD_SUCCESS ("0","广告新增成功！"),
	ADVERTISTMENT_ADD_FAIL ("-1","广告新增失败！"),
	ADVERTISTMENT_ADD_EXCEPTION ("-3","广告新增异常！"),
	ADVERTISTMENT_GET_SUCCESS ("0","广告获取成功！"),
	ADVERTISTMENT_GET_FAIL ("-1","广告获取失败！"),	
	ADVERTISTMENT_GET_EXCEPTION ("-3","广告获取异常！"),	

	ADVERTISTMENT_UPDATE_SUCCESS ("0","广告修改成功！"),
	ADVERTISTMENT_UPDATE_FAIL ("-1","广告修改失败！"),
	ADVERTISTMENT_UPDATE_EXCEPTION  ("-3","广告修改异常！"),

	ADVERTISTMENT_DELETE_SUCCESS ("0","广告删除成功！"),
	ADVERTISTMENT_DELETE_FAIL ("-1","广告删除失败！"),
	ADVERTISTMENT_DELETE_EXCEPTION  ("-3","广告删除异常！"),
	
	/*
	 * 图片上传结果
	 */
	PICTURE_UPLOAD_SUCCESS ("0","图片上传成功！"),
	PICTURE_UPLOAD_FAIL ("-1","图片上传失败！"),
	/*
	 * 定时器任务后台管理的处理结果
	 */
	TIMMERTASK_GET_SUCCESS ("0","定时器任务查询成功！"),
	TIMMERTASK_GET_FAIL ("-1","定时器任务查询暂无记录！"),
	TIMMERTASK_GET_EXCEPTION ("-3","定时器任务查询出现异常！"),
	
	TIMMERTASK_ADD_SUCCESS ("0","定时器任务添加成功！"),
	TIMMERTASK_ADD_FAIL ("-1","定时器任务添加失败！"),
	TIMMERTASK_ADD_EXCEPTION ("-3","定时器任务添加出现异常！"),
	
	TIMMERTASK_UPDATE_SUCCESS ("0","定时器任务修改成功！"),
	TIMMERTASK_UPDATE_FAIL ("-1","定时器任务修改失败！"),
	TIMMERTASK_UPDATE_EXCEPTION ("-3","定时器任务修改出现异常！"),
	
	TIMMERTASK_IS_DELETE("-2","该定时器任务已被注销，不需要注销！"),
	TIMMERTASK_DELETE_SUCCESS ("0","定时器任务注销成功！"),
	TIMMERTASK_DELETE_FAIL ("-1","定时器任务注销失败！"),
	TIMMERTASK_DELETE_EXCEPTION ("-3","定时器任务注销出现异常！"),
	
	TIMMERTASK_ISNOT_DELETE("-2","该定时器任务未被注销，不需要恢复！"),
	TIMMERTASK_RECOVER_SUCCESS ("0","定时器任务恢复成功！"),
	TIMMERTASK_RECOVER_FAIL ("-1","定时器任务恢复失败！"),
	TIMMERTASK_RECOVER_EXCEPTION ("-3","定时器任务恢复出现异常！"),
	
	/*
	 * 定时器任务运行记录查询返回结果
	 */
	TIMMEROPERRATIONRECORD_SEARCH_SUCCESS ("0","定时器运行记录查询成功！"),
	TIMMEROPERRATIONRECORD_SEARCH_FAIL ("-1","定时器运行记录查询暂无记录！"),
	TIMMEROPERRATIONRECORD_SEARCH_EXCEPTION ("-3","定时器运行记录查询出现异常！"),
	/*
	 * 获取服务器ip列表返回结果
	 */
	SERVERIPLIST_GET_SUCCESS ("0","获取服务器IP列表信息成功！"),
	SERVERIPLIST_GET_NORECORD ("-1","获取服务器IP信息暂无记录！"),
	SERVERIPLIST_GET_EXCEPTION ("-3","获取服务器IP列表信息出现异常！"),
	/*
	 * 从缓存读取记录
	 */
	CACHE_GET_SUCCESS ("0","获取缓存信息列表成功！"),
	CACHE_GET_FAIL ("-1","获取缓存信息列表失败！"),
	CACHE_GET_EXCEPTION ("-3","获取缓存信息列表出现异常！"),
	CACHE_NO_RECORD ("-1","缓存暂无记录！"),
	/*
	 * 根据cacheKey获取缓存详情
	 */
	CACHE_DATAIL_GET_SUCCESS ("0","获取缓存详情成功！"),
	CACHE_DATAIL_GET_FAIL ("-1","获取缓存详情失败！"),
	CACHE_DATAIL_GET_EXCEPTION ("-3","获取缓存详情出现异常！"),
	CACHE_DATAIL_NO_RECORD ("-1","获取缓存详情暂无记录！"),
	/*
	 * 根据cacheKey删除缓存
	 */
	CACHE_DELETE_SUCCESS ("0","删除缓存信息成功！"),
	CACHE_DELETE_FAIL ("-1","删除信息失败！"),
	CACHE_DELETE_EXCEPTION ("-3","删除缓存信息出现异常！"),
	/*
	 * 添加广告访问记录
	 */
	ADVERT_ACCESS_RECORD_ADD_SUCCESS("0","添加广告访问记录成功！"),
	ADVERT_ACCESS_RECORD_ADD_FAIL("-1","添加广告访问记录失败！"),
	ADVERT_ACCESS_RECORD_ADD_EXCEPTION("-3","添加广告访问记录出现异常！");

	String code;
	String msg;
	private ReturnResultConsts(String code,String msg){
		this.msg = msg;
		this.code = code;
	}
	
	public String getCode(){
		return code;
	}
	
	public String getMsg(){
		return msg;
	}

}
