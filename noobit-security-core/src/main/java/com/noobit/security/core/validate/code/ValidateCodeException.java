package com.noobit.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 5484548454185106797L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
