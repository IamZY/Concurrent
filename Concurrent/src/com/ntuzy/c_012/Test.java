package com.ntuzy.c_012;

import java.util.concurrent.TimeUnit;

/**
 * 锁的对象是堆内存的中 改变后的锁  不要以字符串作为锁的对象
 */
public class Test {

    Object object = new Object();


    void m() {
        synchronized (object) {

            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }

        }
    }
    
    public static void main(String[] args){

        Test test = new Test();

        new Thread(test::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(test::m,"t2");

        // 改变锁住的对象
        test.object = new Object();

        t2.start();

    }


}
