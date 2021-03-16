package com.learn.jvm.jdk8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: TestStackOverFlowError
 * @description: -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\
 * @date 2020/12/18 10:44
 */
public class TestOutOfMemoryError {
    public static void main(String[] args) {
        new TestOutOfMemoryError().dd();
    }

    List list = new ArrayList<String>();
    void dd(){
        while (true){
            list.add(new Object());//16个字节 1k=1024byte 1m=1024k
        }
    }



}