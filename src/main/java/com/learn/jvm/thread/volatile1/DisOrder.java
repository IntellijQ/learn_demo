package com.learn.jvm.thread.volatile1;

/**
 * @author yds
 * @title: DisOrder
 * @description: 证明指令重排存在
 * @date 2020/12/16 17:46
 */
public class DisOrder {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            };

            Thread other = new Thread() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            };

            one.start();
            other.start();
            one.join();
            other.join();

            String result = "第" + i + "次，x=" + x + ",y=" + y;

            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {

            }
        }
    }
}
