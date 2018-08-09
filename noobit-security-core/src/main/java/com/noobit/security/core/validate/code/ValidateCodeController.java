package com.noobit.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

@RestController
public class ValidateCodeController {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * @author xieyunhai
     * @since 2018/08/10
     *
     * 创建验证码, 根据不同验证码类型, 调用不同的 {@link ValidateCodeProcessor} 接口实现
     *
     * @param request {@link ServletWebRequest}
     * @param type type
     * @throws Exception exception
     */
    @GetMapping("/code/{type}")
    public void createCode(ServletWebRequest request, @PathVariable String type) throws Exception {
        validateCodeProcessors.get(type + "CodeProcessor").create(request);
    }
}
