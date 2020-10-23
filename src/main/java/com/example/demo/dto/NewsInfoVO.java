package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yds
 * @title: NewsInfoVO
 * @description: 新闻信息
 * @date 2020/5/29 19:19
 */
@Data
@ApiModel(description = "新闻信息")
public class NewsInfoVO {
    @ApiModelProperty(value = "新闻ID")
    private String newsId;
    @ApiModelProperty(value = "新闻标题")
    private String newsTitle;
    @ApiModelProperty(value = "新闻URL")
    private String newsURL;
}
