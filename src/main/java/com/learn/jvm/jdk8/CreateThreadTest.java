package com.learn.jvm.jdk8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yds
 * @title: CreateThreadTest
 * @description: TODO
 * @date 2021/3/8 14:19
 */
public class CreateThreadTest{
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        FutureTask<Integer> futureTask = new FutureTask<>(callableTest);
        new Thread(futureTask).start();

        try {
            System.out.println("子线程的返回值: " + futureTask.get());
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableTest implements Callable {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            sum += i;
//            synchronized (this){
//                this.wait();
//            }

//            super.clone();
        }
        System.out.println(Thread.currentThread().getName() + " is running: 执行业务逻辑" + sum);
        Thread.sleep(10000);

        return sum;
    }
}
