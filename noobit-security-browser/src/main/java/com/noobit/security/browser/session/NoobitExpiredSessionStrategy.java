package com.noobit.security.browser.session;

import com.noobit.security.core.properties.SecurityProperties;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

public class NoobitExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {
    public NoobitExpiredSessionStrategy(SecurityProperties securityProperties) {
        super(securityProperties);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        event.getResponse().setContentType("application/json;charset=utf-8");
        event.getResponse().getWriter().write("并发登录");
    }

    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
