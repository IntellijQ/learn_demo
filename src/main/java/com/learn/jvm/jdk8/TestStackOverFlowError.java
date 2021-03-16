package com.learn.jvm.jdk8;

/**
 * @author yds
 * -Xss108k 最低得是108k ，不然异常
 * @title: TestStackOverFlowError
 * @description: TODO
 * @date 2020/12/18 10:44
 */
//Error: Could not create the Java Virtual Machine.
//        Error: A fatal exception has occurred. Program will exit.
//
//        The stack size specified is too small, Specify at least 108k
public class TestStackOverFlowError {
    int a = 0;
    public static void main(String[] args) {
        new TestStackOverFlowError().dd();
    }

    void dd(){
        a ++;
        dd();
    }
}
