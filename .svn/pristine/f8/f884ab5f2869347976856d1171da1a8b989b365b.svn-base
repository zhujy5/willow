package com.nanshan.willow.auth.util;

/**
 * 认证错误码
 * @author zhujy001
 *
 */
public enum ResultCode {
	
	SUCCESS			("0000","操作成功"),
	NO_USER			("0001","用户不存在"),
	WRO_ARGS		("0002","请求参数不合法"),
	NON_TOKEN		("0003","token不存在"),
	EXPIRED_TOKEN	("0004","token失效"),
	NO_PERMISSION	("0005","没有权限"),
	NO_ROLE			("0006","角色为空"),
	ERR_TOKEN		("0010","token比对失败，或在其他设备上登录过"),
	NO_WXOPENID		("0011","微信openId为空"),
	SYS_ERROR		("9999","系统错误导致登录失败：请联系系统管理员");
	
    private String code;
    private String msg;

    private ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
