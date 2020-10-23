package com.example.demo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @title: ResultT
 * @description: 响应结果
 * @author yds
 * @date 2020/5/29  19:33
 */
@Data
@ApiModel(description = "api响应结果")
public class ResultT<T> implements Serializable {
    @ApiModelProperty(value = "是否成功")
    private boolean success = true;
    @ApiModelProperty(value = "返回对象")
    private T data;
    @ApiModelProperty(value = "响应编码")
    private String code;
    @ApiModelProperty(value = "响应信息")
    private String message;


    public ResultT() {
        this.code = ResultCode.OK.getValue();
        this.message = ResultCode.OK.getMessage();
    }

    public ResultT<T> buildSuccess(T data) {
        this.code = ResultCode.OK.getValue();
        this.message = ResultCode.OK.getMessage();
        if (data != null) {
            this.data = data;
        }
        return this;
    }

    public ResultT<T> buildError(String code, String msg, T data) {
        this.code = code;
        this.message = msg;
        if (data != null) {
            this.data = data;
        }
        return this;
    }
}

