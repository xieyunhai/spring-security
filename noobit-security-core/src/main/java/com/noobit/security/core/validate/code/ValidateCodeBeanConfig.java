package com.noobit.security.core.validate.code;

import com.noobit.security.core.properties.SecurityProperties;
import com.noobit.security.core.validate.code.image.ImageCodeGenerator;
import com.noobit.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.noobit.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 图片验证码图片生成器
     * @return {@link ValidateCodeGenerator}
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        return new ImageCodeGenerator(securityProperties);
    }

    /**
     * 短信验证码发送器
     * @return {@link SmsCodeSender}
     */
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
