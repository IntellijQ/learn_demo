package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestGC
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintCommandLineFlags -XX:+UseSerialGC -XX:+PrintGCDetails
 * @description: -Xms20m -Xmx20 -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\
 * @date 2020/12/18 17:42
 */
public class TestGC {
    private static final int INT_1M = 1024 * 1024;

    public static void main(String[] args) {
//        testAllocation();
//        testPretenureSizeThreshold();

        testTenuringThreshold();
//        while (true){
//            testTenuringThreshold1();
//        }

//        testMemory();
    }


    //证明对象优先分配到新生代
    //-XX:SurvivorRatio=8 指定是 新生代中的eden区：一个Survivor的比例=8：1  该案例eden区=8m survivor-1区=1m survivor-2=1m
    //-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintCommandLineFlags -XX:+UseSerialGC -XX:+PrintGCDetails
    public static void testAllocation() {
        byte[] bytes1, bytes2, bytes3, bytes4;
        bytes1 = new byte[2 * INT_1M];
        bytes2 = new byte[2 * INT_1M];
        bytes3 = new byte[2 * INT_1M];
        bytes4 = new byte[4 * INT_1M];
    }


    //-XX:PretenureSizeThreshold 用来指定超过该值的对象直接分配到老年代，避免youngGC
    //-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+PrintCommandLineFlags -XX:+UseSerialGC -XX:+PrintGCDetails
    private static void testPretenureSizeThreshold() {
        byte[] bytes = new byte[7 * INT_1M];
    }


    //
    //-XX:MaxTenuringTheshold=value 用来指定新生代对象从edan 到survivor 的复制次数，超过该值，直接进入老年代
    // -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintCommandLineFlags -XX:+UseSerialGC -XX:+PrintGCDetails -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
    private static void testTenuringThreshold() {
        byte[] bytes1, bytes2, bytes3;
        bytes1 = new byte[INT_1M / 4];//加入eden区+256k（第一次gc时，256k<1m,进入survivor区，第二次gc时，age=1，已经达到MaxTenuringThreshold值会进入老年代）
        bytes2 = new byte[4 * INT_1M];//加入eden区 +4m
        bytes3 = new byte[4 * INT_1M];//此时eden区剩余空间不足以存放byte3=4m,此时发生第一次gc，byte1=256k<survivor from区=1m，age+1；byte2=4m，放到老年代，age+1；bytes3放到eden区
        bytes3 = null;// 清空bytes3 ，Eden区为0，survior=256k
        bytes3 = new byte[4 * INT_1M];//此时eden区剩余空间不足以存放byte3=4m,此时发生第二次gc，survivor from区 中的byte1 的age=1,surivor from 清空，直接接入老年代，bytes3放到eden区

        byte[] ff = new byte[4 * INT_1M];
    }


    // 证明survivor中 相同age的对象唱过一半，则直接接入老年代
    private static void testTenuringThreshold1(){
        byte[] bytes1, bytes2, bytes3;
        bytes1 = new byte[INT_1M / 4];
        bytes2 = new byte[INT_1M / 4];
        bytes3 = new byte[4 * INT_1M];

        byte[] ff2 = new byte[4 * INT_1M];// 发生第一次GC,byte3入老年代，此时老年代=4m; bytes1\bytes2进入survivor区，新生代=0.5m
        //发生gc后，将ff2可放入到新生代，此时新生代4.5m；老年代=4m
        ff2= null;
        ff2 = new byte[4 * INT_1M];//发生第二次GC，survivor区对象此时有age超过一半的对象，+0.5m可直接进入老年代，，同时因为新生代ff2=null，清除-4m，此时新生代=0m；老年代=4.5m
        // 发生GC后，ff2重新4m，可放入到新生代，此时新生代4m；老年代=4.5
    }


//    //验证HandlePromotionFailure 空间担保
//    //-Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintCommandLineFlags -XX:+UseSerialGC -XX:+PrintGCDetails =XX:-HandlePromotionFailure
//    public static void teseHandlePromotion(){
//        byte[] bytes1, bytes2, bytes3,bytes4,bytes5,bytes6,bytes7;
//        bytes1 = new byte[INT_1M * 2];
//        bytes2 = new byte[INT_1M * 2];
//        bytes3 = new byte[INT_1M * 2];
//        bytes1 = null;
//        bytes4 = new byte[INT_1M * 2];
//        bytes5 = new byte[INT_1M * 2];
//        bytes6 = new byte[INT_1M * 2];
//        bytes4 = null;
//        bytes5 = null;
//        bytes6 = null;
//        bytes7 = new byte[INT_1M * 2];
//    }


    public static void testMemory(){
        Object o = new Object();
    }
}
