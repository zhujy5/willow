
package com.nanshan.willow.common.consts;

/**
 * @ClassName: SysConsts
 * @Description: 系统配置key
 * @author: guoqh001
 * @date: 2017年7月6日 上午9:47:50
 */
public class SysConsts {
    
    // 微信
    public static final String WECHAT_APPID = "wechat.appid";
    
    public static final String WECHAT_APPSECRET = "wechat.appsecret";
    
    public static final String SERVER_WECHAT_OPENIDURL = "server.wechat.openIdUrl";
    
    public static final String SERVER_WECHAT_USER_INFO = "server.wechat.user.info";
    
    public static final String SERVER_WECHAT_TICKET = "server.wechat.ticket";
    
    // 微信支付
    public static final String WECHAT_PAY_MCHID = "server.wxpay.mchid";
    
    public static final String WECHAT_PAY_SECRET_KEY = "server.wxpay.secret.key";
    
    public static final String WECHAT_PAY_URL_RECORD = "server.wxpay.url.record"; // 微信支付回调url
    
    public static final String WECHAT_PAY_APPID = "server.wechat.appid";
    
    public static final String WECHAT_PAY_CONN_TIME = "server.wechat.http.conn.time";
    
    public static final String WECHAT_PAY_READ_TIME = "server.wechat.http.read.time";
    
    public static final String WECHAT_PAY_SIGN_TYPE = "server.wechat.sign.type";
    
    public static final String WECHAT_PAY_SANDBOX = "server.wxpay.sandbox";
    
    public static final String WECHAT_PAY_ORDER_DESC_RECHARGE = "server.wxpay.order.desc.recharge";
    
    public static final String WECHAT_PAY_ORDER_DESC_COST = "server.wxpay.order.desc.cost";
    
    // 微信支付app设置
    public static final String WECHAT_PAY_APP_SECRET_KEY = "server.wxpay.app.secret.key";
    
    public static final String WECHAT_PAY_APP_APPID = "server.wechat.app.appid";
    
    public static final String WECHAT_PAY_APP_MCHID = "server.wxpay.app.mchid";
    
    // 证书文件地址
    public static final String WECHAT_PAY_APP_CERT_PATH = "server.wxpay.app.cert.path";

    public static final String WECHAT_PAY_WX_CERT_PATH = "server.wxpay.cert.path";
    
    // 微信支付接口地址
    public static final String WECHAT_PAY_HTTPS_ORDER = "server.wxpay.https.order";
    
    public static final String WECHAT_PAY_HTTPS_REFUND = "server.wxpay.https.refund";
    
    public static final String WECHAT_PAY_HTTPS_APP_REFUND = "server.wxpay.https.app.refund";

    public static final String SERVER_WXPAY_ORDER_QUERY = "server.wxpay.order.query";
    
    public static final String SERVER_WXPAY_REFUND_ORDER_QUERY = "server.wxpay.refund.order.query";
    
    // auth 认证
    // 认证开关
    public static final String SYS_CONF_AUTHCFG = "server.authCfg";
    
    // token密钥
    public static final String SYS_TOKEN_SECRET = "server.token.secret";
    
    // http请求
    public static final String SERVER_HTTP_URL = "server.http.url";
    
    // https请求
    public static final String SERVER_HTTPS_URL = "server.https.url";
    
    // 角色配置
    public static final String SERVER_ROLE_APP = "server.role.app";
    
    // 短信sms
    public static final String SERVER_SMS_URL = "server.sms.url";
    
    public static final String SERVER_SMS_USERNAME = "server.sms.username";
    
    public static final String SERVER_SMS_PASSWORD = "server.sms.password";
    
    public static final String SERVER_SMS_MOVECAR = "server.sms.moveCar";
    
    public static final String SERVER_SMS_REGISTER = "server.sms.register";
    
    public static final String SERVER_SMS_FORGET = "server.sms.forgetPwd";

    public static final String SERVER_SMS_RESERVE_SPACE = "server.sms.reserve.space";

    public static final String SERVER_SMS_RESERVE_REVIEW = "server.sms.reserve.review";

    public static final String SERVER_SMS_RESERVE_ACCEPT = "server.sms.reserve.accept";
    
    public static final String SERVER_SMS_RESERVE_REJECT = "server.sms.reserve.reject";
    
    // 捷顺
    // public static final String SERVER_JS_CUSTOMERID = "server.js.customerId";
	public static final String SERVER_HTTPCLIENT_TIMEOUT = "server.httpclient.timeOut";
    
    public static final String SERVER_JS_LOGINURL = "server.js.loginURL";
    
    public static final String SERVER_JS_BUSINESSURL = "server.js.businessURL";

    public static final String SERVER_JS_NOTIFYURL = "service.jslife.notifyURL";
    
    public static final String SERVER_JS_PAYTYPEURL = "server.js.payTypeURL";
    
    public static final String SERVER_JS_CALLBACK_PAYTYPEURL = "server.js.callback.payTypeURL";

    public static final String SERVER_JS_PARKFLAG = "server.js.parkflag";
    
    public static final String SERVER_JS_PARKCODE = "server.js.parkcode";

    
    public static final String SERVER_JS_EARNESTMONEY = "server.js.earnestMoney";
    
    // 德立云
    public static final String SERVER_DLY_BUSINESSURL = "server.dly.businessURL";
    
    // app下载页面地址
    public static final String SERVER_APP_FILE_PATH = "server.app.file.path";
    
    // apk签名
    public static final String SERVER_APK_SIGN = "server.apk.path";
    
    // 短信限制
    public static final String SERVER_SMS_IP_NUM = "server.sms.ip.num";
    
    public static final String SERVER_SMS_IP_TIME = "server.sms.ip.time";
    
    public static final String SERVER_SMS_USER_NUM = "server.sms.user.num";
    
    public static final String SERVER_SMS_USER_TIME = "server.sms.user.time";
    
    public static final String SERVER_SMS_USER_CFG = "server.sms.user.cfg";
    
    public static final String SERVER_SMS_IP_CFG = "server.sms.ip.cfg";
    
    public static final String SERVER_FILE_PATH = "server.file.path";
    
    // 后台管理重置app用户登陆密码
    public static final String BBPARK_SYS_CUSTOMER_PWD = "bbpark.sys.customer.pwd";
    
    // 付款成功，通知第三方异常后重调次数
    public static final String SERVER_ORDER_NOTICE_EXEC = "server.order.notice.exec";
    
    // 重调第三方间隔时间
    public static final String SERVER_ORDER_EXEC_TIME = "server.order.exec.time";
    
    public static final String SERVER_ORDER_EXEC_SMS = "server.order.exec.sms";
    
    public static final String SERVER_ADMIN_MOLIBE = "server.admin.molibe";
    
    // 消息模板id
    public static final String SERVER_MESSAGEID_OUTCAR = "server.messageid.outcar";
    
    public static final String SERVER_MESSAGEID_INCAR = "server.messageid.incar";
    
    public static final String SERVER_MESSAGEID_REFUND = "server.messageid.refund";
    
    public static final String SERVER_MESSAGEID_RECHARGE = "server.messageid.recharge";

    public static final String SERVER_MESSAGEID_EXCEPTION = "server.messageid.exception";

    // e行销短信服务url
    public static final String SERVER_SMS_ESALES_SERVER = "server.sms.esales.server";
    
    // e行销短信安全签名key
    public static final String SERVER_SMS_SIGN_SECRETKEY = "server.sms.sign.secretkey";
    
    // 扫描商家优惠劵跳转url
    public static final String SERVER_APP_QRCODE_URl = "server.app.qrcode.url";
    
    // ==============支付宝配置================
    // 支付宝应用appid
    public static final String SERVER_ALIPAY_APPID = "server.alipay.appid";
    
    // 请求域名
    public static final String SERVER_ALIPAY_HTTPS_URL = "server.alipay.https.url";
    
    // 私钥
    public static final String SERVER_ALIPAY_PAIVATE_KEY_URL = "server.alipay.private.key.url";
    
    // 公钥
    public static final String SERVER_ALIPAY_PUBLIC_KEY = "server.alipay.public.key";
    
    public static final String SERVER_ALIPAY_SIGN_TYPE = "server.alipay.sign.type";
    
    public static final String SERVER_ALIPAY_NOTIFY_URL = "server.alipay.notify.url";
    
    public static final String SERVER_ALIPAY_PUBLIC_APP_KEY = "server.alipay.public.app.key";
    
    public static final String SERVER_ALIPAY_REFUND_NOTIFY_URL = "server.alipay.refund.notify.url";
    
    // 批处理指定服务器IP
    public static final String SERVER_TIMMER_PERMISSION_IP = "server.timmer.permission.ip";
    
    // 腾讯云appid，appkey
    public static final String SERVER_QCLOUD_APP_ID = "server.qcloud.app.id";
    
    public static final String SERVER_QCLOUD_APP_KEY = "server.qcloud.app.key";
    
    // 获取accessToken的url
    public static final String SERVER_WECHAT_ACCESS_TOKEN_URL = "server.wechat.access.token.url";
    
    // 发送微信公众号消息url
    public static final String SERVER_WECHAT_MESSAGE_URL = "server.wechat.message.url";
    
    // 高德地图相关key
    public static final String LBS_WEB_SERVICE_PRIVATE_KEY = "lbs.web.service.private.key";
    
    public static final String LBS_WEB_SERVICE_KEY = "lbs.web.service.key";
    
    public static final String LBS_WEB_LOCATION_URL = "lbs.web.location.url";
    
    // 腾讯云发送短信的url
    public static final String SERVER_QCLOUD_SMS_URL = "server.qcloud.sms.url";
    
    public static final String SERVER_SMS_CHANNEL = "server.sms.channel";
    
    public static final String SERVER_SMS_QCLOUD_SMSHEAD = "server.sms.qcloud.smshead";// 短信签名
    
    // 停车场图片保存的地址
    public static final String SYS_PARKLOT_PIC_ADDRESS = "sys.parklot.pic.address";
    
    // 商家用户保存的地址
    public static final String SYS_SELLER_PIC_ADDRESS = "sys.seller.pic.address";
    
    public static final String SYS_ADVERT_PIC_ADDRESS = "sys.advert.pic.address";
    
    // ====================快付通===============
    public static final String SERVER_KPPPAY_MERCHANTID = "server.kpppay.merchantid";
    
    public static final String SERVER_KPPPAY_PAY_NOTITY_URL = "server.kpppay.pay.notity.url";
    
    public static final String SERVER_KPPPAY_INTERFACE_VERSION = "server.kpppay.interface.version";
    
    public static final String SERVER_KPPPAY_SEC_MERCHANTID = "server.kpppay.sec.merchantid";
    
    public static final String SERVER_RECHARGE_PRODUCT_ID = "server.recharge.product.id";
    
    public static final String SERVER_COST_PRODUCT_ID = "server.cost.product.id";
    
    public static final String SERVER_IS_USE_KFTPAY = "server.is.use.kftpay";

    // 私钥地址
    public static final String SERVER_KPPPAY_PRIVATE_CERT_URL = "server.kpppay.private.cert.url";

    // 公钥地址
    public static final String SERVER_KPPPAY_PUBLIC_CERT_URL = "server.kpppay.public.cert.url";
    
    public static final String SERVER_KPPPAY_CERT_PASSWORD = "server.kpppay.cert.password";

    public static final String SERVER_KPPPAY_HTTP_PORT = "server.kpppay.http.port";

    public static final String SERVER_KPPPAY_PROTOCOL = "server.kpppay.protocol";

    public static final String SERVER_KPPPAY_HTTP_DOMAIN = "server.kpppay.http.domain";

    public static final String SERVER_KPPPAY_BILL_PATH = "server.kpppay.bill.path";

    public static final String SERVER_KPPPAY_MERCHANT_IP = "server.kpppay.merchant.ip";
    
    public static final String SERVER_APP_IS_USE_KFTPAY = "server.app.is.use.kftpay";
    
    public static final String SERVER_JSAPI_IS_USE_KFTPAY = "server.jsapi.is.use.kftpay";

    // ================== 快付通完====================
    /** 用户头像存放地址 */
    public static final String SERVER_USER_HEADPIC_ADDRESS = "server.user.headpic.address";

    /*** 异常消息存放的地址 */
    public static final String SERVER_EXCEPTION_MSG_ADDRESS = "server.exception.msg.address";

    /** app消息模板id */
    public static final String SERVER_SMS_ENTERCAR_TEMPLATE = "server.sms.entercar.template";// 进场消息模板
    
    public static final String SERVER_SMS_OUTCAR_TEMPLATE = "server.sms.outcar.template";// 出场消息模板
    
    public static final String SERVER_SMS_RECHARGE_TEMPLATE = "server.sms.recharge.template";// 充值消息模板
    
    public static final String SERVER_SMS_PAYMONTHCARD_TEMPLATE = "server.sms.paymonthcard.template";// 月卡充值消息模板
    
    public static final String SERVER_SMS_CUPONDISCOUNT_TEMPLATE = "server.sms.cupondiscount.template";// 优惠券打折消息模板
    
    public static final String SERVER_SMS_CUPONREDUCTION_TEMPLATE = "server.sms.cuponreduction.template";// 优惠券优惠消息模板
    
    public static final String SERVER_SMS_PARKINGCHARGING_TEMPLATE = "server.sms.parkingcharging.template";// 停车缴费消息模板
    
    public static final String SERVER_SMS_RESTOREMONEY_TEMPLATE = "server.sms.restoremoney.template";// 退款消息模板
    
    public static final String SERVER_SMS_CUSTOMERORDER_TEMPLATE = "server.sms.customerorder.template";// 客户预定车场消息模板
    
    public static final String SERVER_KPPPAY_REFUND_DESC = "server.kpppay.refund.desc";
    
    public static final String SERVER_SMS_MONTHCARD_WILL_EXPIRED = "server.sms.monthcard.will.expired";//月卡即将到期

    
    
    // 回调接口校验
    public static final String SERVER_NOTITY_VERIFY_SECRETID = "server.notity.verify.secretId";
    
    public static final String SERVER_NOTITY_VERIFY_SECRETKEY = "server.notity.verify.secretKey";

    public static final String SERVER_THIRDPARTY_NOTITY_URL = "server.thirdParty.notity.url";
    
    // 前海财险广告url生成
    public static final String SERVER_ADVERT_QHINS_URL = "server.advert.qhins.url";

    public static final String SERVER_ADVERT_QHINS_URL_KEY = "server.advert.qhins.url.key";
    
    public static final String SERVER_THIRDPART_RECHAGE_SIGNSECRET = "server.thirdPart.rechage.signSecret";
    
    public static final String SERVER_CHANGE_CONTROL_TIP = "server.change.control.tip";

    public static final String SERVER_MONITOR_TIMELENG = "server.monitor.timeLeng";

    //支付异常订单
    //异常订单数量，超过这个设置数量，则发送消息告知管理员
    public static final String SERVER_PAY_EXEC_NOTITY_SIZE = "server.pay.exec.notity.size";
    public static final String SERVER_PAY_EXEC_QUERY_TIME = "server.pay.exec.query.time";
    public static final String SERVER_PAY_KFT_OTIFY_TIME = "server.pay.kft.otify.time";
    public static final String SERVER_PAY_WX_OTIFY_TIME = "server.pay.wx.otify.time";
    

    //德立云停车场通讯云密钥
    public static final String SERVER_DLY_PARKLOT1_KEY = "server.dly.parklot1.key";
    public static final String SERVER_DLY_PARKLOT2_KEY = "server.dly.parklot2.key";

    //月卡过期延期开关和月卡过期延期方式
    public static final String MONTH_CARD_DELAY_SWITCH = "month.card.delay.switch";
    public static final String MONTH_CARD_OVERDUE_SWITCH = "month.card.overdue.switch";
    public static final String MONTH_CARD_OVERDUE_DELAY_TYPE = "month.card.overdue.delay.type";
    
    //无牌车
    public static final String DOWN_CAR_CERTIFICATE_SWITCH = "down.car.certificate.switch";
    
    //第三方调用接口开放开关
    public static final String THIRDPART_ADVERT_SERVICE_SWITCH = "thirdpart.advert.service.switch";
    public static final String THIRDPART_SERVICE_WHITEIPS = "thirdpart.service.whiteips";
    
    //用户gps坐标转换为高德坐标
    public static final String SERVER_GPS_CHANGE_GD_URL = "server.gps.change.gd.url";

}
