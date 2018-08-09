package com.noobit.code;

import com.noobit.security.core.validate.code.image.ImageCode;
import com.noobit.security.core.validate.code.ValidateCodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.ServletWebRequest;

//@Component("imageCodeGenerator")
@Slf4j
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        log.info("图形验证码");
        return null;
    }
}
