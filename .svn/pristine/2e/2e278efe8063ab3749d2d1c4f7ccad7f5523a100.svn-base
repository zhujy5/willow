/******************************************************************************
 * Copyright (C) 2017 Qian Hai Life Insurance CO.,LTD
 * All Rights Reserved.
 * 本软件为前海人寿保险股份有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/

package com.nanshan.willow.common.consts;
/**
 * @ClassName:  ManufacturerCodes
 * @Description:TODO(德立云编码定义 0 正确 1 服务不可用 2 没有证书/没有认证 3 授权的密钥错误 4 签名错误 5 帐号或密码错误 6 参数无效 7 缺少必须参数 8 非法操作 9 无权操作)
 * @author: wangsj002
 * @date:   2017年11月7日 wangsj002
 *
 */
public enum ManufacturerCodes {
    CODE_DLY_FAIL          ("-1", "-1", "车辆未入场"),
    CODE_DLY_SUCESS         ("0", "0", "正常返回停车信息"),
    CODE_DLY_ERROR            ("1", "1", "查询失败"),
    CODE_DLY_CAR_NOT_FIND   ("2", "6", "查不到停车记录"),
    CODE_DLY_MONTH_CAR      ("5", "2", "月卡用户，无需缴费"),
    CODE_DLY_HAVE_PAY      ("9", "9", "已缴费，滞留时间内"),
    CODE_DLY_CONNECT_ERROR  ("99", "99", "通讯异常"),
    CODE_DLY_SYSTEM_ERROR  ("9999", "9999", "未知的系统错误");

    private String code;

    private String orginCode;

    private String msg;

    private ManufacturerCodes(String code, String orginCode, String msg) {
        this.code = code;
        this.orginCode=orginCode;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getOrginCode() {
        return this.orginCode;
    }

    public String getMsg() {
        return this.msg;
    }
}
