package com.noobit.security.core.properties;

import lombok.Data;

@Data
public class SessionProperties {
    private int maximumSessions = 1;

    private String sessionInvalidUrl = SecurityConstants.DEFAULT_SESSION_INVALID_URL;
}
