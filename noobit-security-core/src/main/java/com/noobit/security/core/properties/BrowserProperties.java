package com.noobit.security.core.properties;

import lombok.Data;

@Data
public class BrowserProperties {
    /* session 管理配置项 */
    private SessionProperties session = new SessionProperties();
    /* 登录页面, 当引发登录行为的 url 以 html 结尾时, 会跳转到这里配置的 url 上 */
    private String signInPage = SecurityConstants.DEFAULT_SIGN_IN_PAGE_URL;

    /* 记住我 功能的有效时间, 如果配置了, 则跳转到指定的 url, 如果没配置, 则返回 json 数据 */
    private int rememberMeSeconds = 3600;

    /* 退出成功时跳转的 url, 如果配置了, 则跳转到指定的 url, 如果没配置, 则返回 json 数据 */
    private String signOutUrl;

    private String signUpUrl = "/default-signup.html";
    /* 记住我 */
    private String loginPage = "/default-login.html";
    private LoginType loginType = LoginType.JSON;
}
