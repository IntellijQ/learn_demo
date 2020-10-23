package com.example.demo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yds
 * @title: NewsPageParam
 * @description: 新闻参数
 * @date 2020/5/30  0:08
 */
@Data
@ApiModel(description = "新闻参数")
public class NewsPageParam {
    @ApiModelProperty(value = "每页数量")
    private String pageSize;
    @ApiModelProperty(value = "当前页码")
    private String pageNo;
    @ApiModelProperty(value = "新闻标题")
    private String newsTitle;
}
