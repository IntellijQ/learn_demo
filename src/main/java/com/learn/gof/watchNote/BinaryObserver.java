package com.learn.gof.watchNote;

/**
 * @author yds
 * @title: BinaryObserver
 * @description: TODO
 * @date 2021/4/22 15:10
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}