package com.noobit.security.core.properties;

import lombok.Data;

@Data
public class BrowserProperties {
    private String signupUrl = "/default-signup.html";
    private String loginPage = "/default-login.html";
    private LoginType loginType = LoginType.REDIRECT;
    private int rememberMeSeconds = 3600;
}
