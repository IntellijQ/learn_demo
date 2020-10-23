package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yds
 * @title: UserInfoVO
 * @description: 用户信息
 * @date 2020/5/29 19:19
 */
@Data
@ApiModel(description = "用户信息")
public class UserInfoVO {
    @ApiModelProperty(value = "用户ID")
    private String userId;
    @ApiModelProperty(value = "用户姓名")
    private String userName;
}
