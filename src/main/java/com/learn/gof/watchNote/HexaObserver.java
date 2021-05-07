package com.learn.gof.watchNote;

/**
 * @author yds
 * @title: HexaObserver
 * @description: TODO
 * @date 2021/4/22 15:11
 */
public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}