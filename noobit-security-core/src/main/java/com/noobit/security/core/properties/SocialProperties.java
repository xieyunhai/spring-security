package com.noobit.security.core.properties;

import lombok.Data;

@Data
public class SocialProperties {
    private QQProperties qq = new QQProperties();
    private WeixinProperties weixin = new WeixinProperties();

    private String filterProcessesUrl = "/auth";
}
