package com.learn.gof.chuangjianxing;

/**
 * @author yds
 * @title: SampleFactoryTest
 * @description: TODO
 * @date 2020/5/2814:25
 */
public class SampleFactoryTest {
    public static void main(String[] args) {
        //task ：fruit

        //taget 1
//        Panda panda = new Panda();
//        panda.eat();
//
//        //taget 2
//        Tiger tiger = new Tiger();
//        tiger.eat();

        SampleFactory sampleFactory = new SampleFactory();
        Animail animail = sampleFactory.newInstance();
        animail.eat();
    }
}
