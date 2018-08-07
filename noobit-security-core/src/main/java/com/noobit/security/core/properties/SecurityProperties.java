package com.noobit.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "noobit.security")
@Data
public class SecurityProperties {

    // 属性名需要为 browser 与 application.properties 里对应
    private BrowserProperties browser = new BrowserProperties();

}
