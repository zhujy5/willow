
package com.nanshan.willow.common.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tools {

    private static final Logger log = LoggerFactory.getLogger(Tools.class);

    /*
     * 保证多线程环境下SimpleDateFormat的安全
     */
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

    /**
     * 检测字符串是否不为空(null,"","null")
     *
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s) {
        return s != null && !"".equals(s) && !"null".equals(s);
    }
    
    /**
     * 检测字符串是否为空(null,"","null")
     *
     * @param s
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s) || "null".equals(s);
    }
    
    /**
     * 字符串转换为字符串数组
     *
     * @param str 字符串
     * @param splitRegex 分隔符
     * @return
     */
    public static String[] str2StrArray(String str, String splitRegex) {
        if (isEmpty(str)) {
            return null;
        }
        return str.split(splitRegex);
    }
    
    /**
     * 用默认的分隔符(,)将字符串转换为字符串数组
     *
     * @param str 字符串
     * @return
     */
    public static String[] str2StrArray(String str) {
        return str2StrArray(str, ",\\s*");
    }
    
    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
     *
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String date2String(Date date) {
        return date2String(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    /** 返回图像时间戳 */
    public static String getImgTime(Date sourceDate) {
        return getSimpleDateFormat("yyyyMMddHHmmssSSS").format(sourceDate);
    }
    
    /** 返回时间戳 到秒 */
    public static String getTaderime(Date sourceDate) {
        return getSimpleDateFormat("yyyyMMddHHmmss").format(sourceDate);
    }
    
    private static SimpleDateFormat getSimpleDateFormat(String pattern) {
        SimpleDateFormat format = threadLocal.get();
        format.applyPattern(pattern);
        return format;
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
     *
     * @param date
     * @return
     */
    public static Date string2Date(String date) {
        if (notEmpty(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                log.error(e.getMessage(), e);
            }
            return new Date();
        } else {
            return null;
        }
    }
    
    /**
     * 按照参数format的格式，日期转字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String date2String(Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } else {
            return "";
        }
    }
    
    /**
     * 验证日期时间
     *
     * @param date
     * @return boolean
     */
    public static boolean checkDateTime(String date) {
        Pattern pattern = Pattern.compile(
            "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
    
    /**
     * 验证邮箱
     *
     * @param email
     * @return boolean
     */
    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(
            "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(14[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static void main(String[] args) {
        log.info(Tools.isMobileNO("17708162287")+"");
        log.debug(getImgTime(new Date()));
    }
    
    /**
     * 拆分字符串
     *
     * @param src 待拆分的字符串
     * @param flag 拆分标志
     * @return
     */
    public static String[] getSplit(String src, String flag) {
        String[] result = null;
        if (src == null) {
            return result;
        }
        List<String> l = new ArrayList<String>();
        try {
            int s = 0;
            int x = src.indexOf(flag);
            while (src.indexOf(flag) > -1) {
                l.add(src.substring(s, x));
                src = src.substring(x + flag.length());
                x = src.indexOf(flag);
            }
            l.add(src);
            if (l.isEmpty()) {
                return result;
            }
            result = new String[l.size()];
            for (int i = 0; i < l.size(); i++) {
                result[i] = l.get(i);
            }
        } catch (Exception e) {
            log.error("PublicMethod.getSplit error:" + e.getMessage(), e);
            return result;
        }
        return result;
    }
    
    /**
     * @category按位数生成随机密码(大写字母加数字) @param lenth
     * @return String password
     */
    public static String createRandomPassword(int len) {
        Random r = new Random();
        String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer password = new StringBuffer();
        for (int i = 0; i < len; i++) {
            password.append(s.charAt(r.nextInt(s.length())));
        }
        return password.toString();
    }
    
    /**
     * @category按位数生成随机密码(数字) @param lenth
     * @return String password
     */
    public static String createRandom(int len) {
        Random r = new Random();
        String s = "0123456789";
        StringBuffer random = new StringBuffer();
        for (int i = 0; i < len; i++) {
            random.append(s.charAt(r.nextInt(s.length())));
        }
        return random.toString();
    }
    
    public static String removeNull(String stringa) {
        return stringa == null ? "" : stringa;
    }
    
    /**
     * 密码规则 必顺包含 大写 小写 数字 特殊字符
     *
     * @param pwd
     * @return
     */
    public static boolean isPassWord(String pwd) {
        String key = "^(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9])).*$";
        Pattern pattern = Pattern.compile(key);
        
        Matcher matcher = pattern.matcher(pwd);
        return matcher.matches();
    }
    
    /**
     * 方法注释信息(金额格式化)
     *
     * @param amount
     * @return
     */
    public static String formatDecimal(BigDecimal amount) {
        NumberFormat nf = new DecimalFormat("###########0.00");
        if(amount==null){
            amount=new BigDecimal(0);
        }
        String testStr = nf.format(amount);
        return testStr;
    }

    /**
     * String 转unicode
     *
     * @Title: string2Unicode
     * @author guoqh001
     * @Date 2017年7月11日 下午4:04:07
     */
    public static String stringForUnicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }

        return unicode.toString();
    }

    /**
     * unicode转String
     *
     * @Title: unicodeForString
     * @author guoqh001
     * @Date 2017年7月11日 下午4:04:39
     */
    public static String unicodeForString(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }

    public static Map<String, Object> transBeanToMap(Object obj) {
        
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if (value != null) {
                        map.put(key, value);
                    }
                }
                
            }
        } catch (Exception e) {
            log.error("transBean2Map Error ", e);
        }
        
        return map;
        
    }

    /**
     * @Title 方法注释信息(模式匹配)
     *
     * @param dataString
     * @param regex
     * @return
     */
    public static String getTimeNum(String dataString, String regex) {
        // Pattern是一个正则表达式经编译后的表现模式
        Pattern p = Pattern.compile(regex);
        // 一个Matcher对象是一个状态机器，它依据Pattern对象做为匹配模式对字符串展开匹配检查。
        Matcher m = p.matcher(dataString);
        if (m.find()) {
            return m.group();
        } else {
            return "0";
        }
        
    }
    
    /**
     * @Title 方法注释信息(获取秒数 格式：4天7小时46分钟)
     *
     * @param time
     * @return
     */
    public static String getParkTime(String time) {
        int days = Integer.parseInt(getTimeNum(time, "\\d*天").replace("天", ""));
        int hours = Integer.parseInt(getTimeNum(time, "\\d*小时").replace("小时", ""));
        int minutes = Integer.parseInt(getTimeNum(time, "\\d*分钟").replace("分钟", ""));
        long seconds = (minutes + hours * 60 + days * 24 * 60) * 60;
        return String.valueOf(seconds);
    }
}
