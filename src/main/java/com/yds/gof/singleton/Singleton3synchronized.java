package com.yds.gof.singleton;

/**
 * @author yds
 * @title: Singleton
 * @description: 懒汉单例 ---使用synchronized
 * @date 2020/5/2816:32
 */
public class Singleton3synchronized {
    private static volatile Singleton3synchronized singleton;
    int age = 189898;

    public int getAge() {
        return age;
    }

    //    /**
//     * 在方法上使用 synchronized 会有性能上的消耗，其实只需要在new 的时候 进行同步就行
//     * @author yds
//     * @date 2020/5/28 16:53
//     * @param
//     * @return com.yds.gof.singleton.Singleton3synchronized
//     */
//    public static synchronized Singleton3synchronized newInstance() throws InterruptedException {
//        if(singleton == null){
//            Thread.sleep(2000);
//            singleton = new Singleton3synchronized();
//        }
//        return singleton;
//    }


    /**
     * double check
     * 同时要使用volatitle 修饰，避免指令重排问题
     * 在方法上使用 synchronized 会有性能上的消耗，其实只需要在new 的时候 进行同步就行
     * @author yds
     * @date 2020/5/28 16:53
     * @param
     * @return com.yds.gof.singleton.Singleton3synchronized
     */
    public static Singleton3synchronized newInstance() throws InterruptedException {
        if(singleton == null){
            synchronized(Singleton3synchronized.class){
                if(singleton == null){
                    singleton = new Singleton3synchronized();
                }
            }
        }
        if(singleton.getAge() == 0){
            System.out.println("哈哈哈，我被重排了");
        }
        return singleton;
    }
}
