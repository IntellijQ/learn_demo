package pick;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yds
 * @title: pick.ThreadOrderTest
 * @description: 多线程顺序
 * @date 2021/4/25 21:36
 */
public class ThreadOrderTest {

    static Thread threadOne = null;
    static Thread threadTwo = null;
    static Thread threadThree = null;
    static Thread threadFour = null;
    public static void main(String[] args) {
        threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 4;i++){
                    System.out.print("A");
                    LockSupport.unpark(threadTwo);
                    LockSupport.park();

                }
            }
        });
        threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 4;i++){
                    LockSupport.park();
                    System.out.print("B");
                    LockSupport.unpark(threadThree);
                }
            }
        });
        threadThree = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 4;i++){
                    LockSupport.park();
                    System.out.print("C");
                    LockSupport.unpark(threadFour);
                }
            }
        });
        threadFour = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 4;i++){
                    LockSupport.park();
                    System.out.print("D");
                    LockSupport.unpark(threadOne);

                }
            }
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

    }

}
