package com.noobit.security.core.validate.code.image;

import com.noobit.security.core.validate.code.ValidateCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;

@EqualsAndHashCode(callSuper = true)
@Data
public class ImageCode extends ValidateCode {
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public boolean isExpired() {
        return super.isExpired();
    }
}
