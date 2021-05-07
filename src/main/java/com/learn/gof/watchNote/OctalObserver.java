package com.learn.gof.watchNote;

/**
 * @author yds
 * @title: OctalObserver
 * @description: TODO
 * @date 2021/4/22 15:11
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}