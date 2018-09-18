package com.noobit.security.core.social.weixin.connect;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.social.oauth2.AccessGrant;

@EqualsAndHashCode(callSuper = true)
@Data
public class WeixinAccessGrant extends AccessGrant {
    private static final long serialVersionUID = -6008057205139583140L;
    private String openId;

    public WeixinAccessGrant() {
        super("");
    }

    public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }
}
