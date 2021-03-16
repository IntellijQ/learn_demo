package com.learn.jvm.jdk8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: TestMemory
 * @description: TODO
 * @date 2020/12/20 21:22
 */
public class TestMemory {
    public static void main(String[] args) throws InterruptedException {
        dd();
    }

    public static void dd() throws InterruptedException {
        List<Mm> mms = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            mms.add(new Mm());
        }
    }

    static class Mm{
        byte[] dd = new byte[64*1024];
    }
}

