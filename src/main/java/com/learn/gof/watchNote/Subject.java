package com.learn.gof.watchNote;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: Subject
 * @description: TODO
 * @date 2021/4/22 15:09
 */
public class Subject {
    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
