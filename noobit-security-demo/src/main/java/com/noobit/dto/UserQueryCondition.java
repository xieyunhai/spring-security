package com.noobit.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserQueryCondition {
    private String username;
    @ApiModelProperty("起始年龄")
    private int age;
    @ApiModelProperty("终止年龄")
    private int ageTo;
}
