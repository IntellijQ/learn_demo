package com.proxy;

import com.alibaba.fastjson.JSON;

import java.util.Properties;

/**
 * @author yds
 * @title: CglibProxy
 * @description: TODO
 * @date 2021/2/26 14:40
 */
public class CglibProxy {
    public static void main(String[] args) {
        System.out.println( System.getenv());
        Properties properties = System.getProperties();
        System.out.println(JSON.toJSONString(properties));
        System.out.println( System.getProperty("java.vm.name"));
    }
}
