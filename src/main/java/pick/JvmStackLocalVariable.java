package pick;

/**
 * @author yds
 * @title: pick.JvmStackLocalVariable
 * @description: TODO
 * @date 2021/4/20 17:27
 */
public class JvmStackLocalVariable {

    Object o = new Object();
    public int count = 0;

    public static void main(String[] args) {
//        pick.JvmStackLocalVariable jvmStackLocalVariable
//                = new pick.JvmStackLocalVariable();
//        int num = 3;
//        jvmStackLocalVariable.test1();
//        main(args);

//        int a = Integer.MAX_VALUE + 1;
//        System.out.println(a);
//        System.out.println(Integer.MAX_VALUE);


        new Thread(new Runnable() {
            @Override
            public void run() {
                new JvmStackLocalVariable().test1("线程1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new JvmStackLocalVariable().test1("线程2");
            }
        }).start();


    }

    private void test1(String dd) {

        // put
        System.out.println(o);
        synchronized (o){
//        synchronized (pick.JvmStackLocalVariable.class){
            for (int i = 0; i < 10; i++) {
                System.out.println(dd + "...");
            }
        }

    }

//    private void test12() {
//        synchronized (pick.JvmStackLocalVariable.class){
//            System.out.println("tes2...");
//        }
//
//    }
}
