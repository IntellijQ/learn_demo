package com.learn.gof.watchNote;

/**
 * @author yds
 * @title: ObserverPatternDemo
 * @description: TODO
 * @date 2021/4/22 15:12
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);

        System.out.println("=======================");
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}