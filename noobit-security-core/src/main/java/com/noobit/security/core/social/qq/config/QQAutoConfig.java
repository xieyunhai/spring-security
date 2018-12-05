package com.noobit.security.core.social.qq.config;

import com.noobit.security.core.properties.QQProperties;
import com.noobit.security.core.properties.SecurityProperties;
import com.noobit.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;

@Configuration
@ConditionalOnProperty(prefix = "noobit.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        QQProperties qq = securityProperties.getSocial().getQq();
        connectionFactoryConfigurer.addConnectionFactory(
                new QQConnectionFactory(qq.getProviderId(), qq.getAppId(), qq.getAppSecret()));
    }
}
