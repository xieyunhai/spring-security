package com.noobit.security.core.social.qq.connect;

import com.noobit.security.core.social.qq.api.QQ;
import com.noobit.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class QQServiceProvide extends AbstractOAuth2ServiceProvider<QQ> {
    private String appId;
    // note: qq 规定的, 不需要单独提出来配置
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";


    /**
     * Create a new {@link OAuth2ServiceProvider}.
     */
    public QQServiceProvide(String appId, String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
