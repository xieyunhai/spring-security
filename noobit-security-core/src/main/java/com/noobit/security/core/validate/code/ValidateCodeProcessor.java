package com.noobit.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeProcessor {

    /**
     * 创建校验码
     *
     * @param request {@link ServletWebRequest}
     * @throws Exception exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验校验码
     *
     * @param request {@link ServletWebRequest}
     */
    void validate(ServletWebRequest request);
}
