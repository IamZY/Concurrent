package com.ntuzy.c_007;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另一个同步方法  一个线程已经拥有某个对象的锁 再次申请的时候仍然会再次得到该对象的锁
 * 也就是synchronized获得的锁是可以重入的   在锁的上面加个数字
 */
public class Test {

    synchronized void m1() {
        System.out.println(" m1 start ... ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }


    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

}
