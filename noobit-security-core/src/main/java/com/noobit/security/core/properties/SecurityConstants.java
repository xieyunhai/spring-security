package com.noobit.security.core.properties;

public class SecurityConstants {
    /* 默认的处理验证码的 url 前缀 */
    public final static String  DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
    /**
     * @see
     */
    public final static String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    /* 默认用户民密码登录请求处理的 url */
    public final static String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";
    /* 默认手机验证码登录请求处理的 url */
    public final static String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";
    /**
     * @see
     */
    public final static String DEFAULT_LOGIN_PAGE_URL = "default-login.html";
    /* 验证图片验证码时, http 请求中默认的携带图片验证码信息的参数的名称 */
    public final static String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    /* 验证图片验证码时, http 请求中默认的携带短信验证码信息的参数的名称 */
    public final static String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /* 发送短信验证码 或 验证短信验证码时, 传递手机号的参数的名称 */
    public final static String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";

    /* session 失效默认的跳转地址 */
    public static final String DEFAULT_SESSION_INVALID_URL = "/default-session-invalid.html";
    public static final String DEFAULT_SIGN_IN_PAGE_URL = "/default-login.html";
}
