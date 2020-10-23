package com.example.demo;

/**
 * @author Intellij
 * @title: Test
 * @description: TODO
 * @date 2020/6/12 16:58
 */
public class Test {
    int x = 0;
    /*volatile*/  boolean flag = false;

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.write();
            }
        },"write 线程").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.read();
            }
        },"read 线程").start();



    }


    public void write(){
        x = 34;
        flag = true;
        System.out.println("write x = " + x);
    }

    public void read(){
        if(true){
            System.out.println("read x = " + x);
        }
    }
}

