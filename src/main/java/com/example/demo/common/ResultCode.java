package com.example.demo.common;

/**
 * @author yds
 * @title: ResultCode
 * @description: 响应码
 * @date 2020/5/29 19:12
 */
public enum  ResultCode {
    OK("000000", "成功"),
    FAIL("999999","失败"),
    ;
    String value;
    String message;

    ResultCode(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getValue() {
        return this.value;
    }

}
