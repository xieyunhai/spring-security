package com.noobit.security.core.social.weixin.config;

import com.noobit.security.core.properties.SecurityProperties;
import com.noobit.security.core.properties.WeixinProperties;
import com.noobit.security.core.social.NoobitConnectionView;
import com.noobit.security.core.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.web.servlet.View;

@Configuration
@ConditionalOnProperty(prefix = "noobit.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        WeixinProperties weixin = securityProperties.getSocial().getWeixin();
        connectionFactoryConfigurer.addConnectionFactory(
                new WeixinConnectionFactory(weixin.getProviderId(), weixin.getAppId(), weixin.getAppSecret()));
    }

    @Bean({"connect/weixinConnected", "connect/weixinConnect"})
    @ConditionalOnMissingBean(name = "weixinConnectedView")
    public View weixinConnectedView() {
        return new NoobitConnectionView();
    }
}
