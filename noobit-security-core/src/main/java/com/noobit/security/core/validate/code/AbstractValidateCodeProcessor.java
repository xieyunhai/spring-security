package com.noobit.security.core.validate.code;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    public static final String SESSION_KEY_PREFIX = "SESSION_KEY_VALIDATE_CODE_";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /* note：收集系统中所有的 <code>ValidateCodeGenerator<code> 接口的实现 */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    @SuppressWarnings("unchecked")
    private C generate(ServletWebRequest request) {
        String type = getProcessorType(request);
        ValidateCodeGenerator codeGenerator = this.validateCodeGenerators.get(type + "CodeGenerator");
        return (C) codeGenerator.generate(request);
    }

    private void save(ServletWebRequest request, C validateCode) {
        sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX + getProcessorType(request).toUpperCase(), validateCode);
    }

    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

    private String getProcessorType(ServletWebRequest request) {
        return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
    }
}
