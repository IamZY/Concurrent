package com.ntuzy.c_009;

import java.util.concurrent.TimeUnit;

/**
 * 线程抛出异常后 锁就被释放了
 */
public class Test {
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start ");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count= " + count);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5) {
                int i = 1 / 0;
            }

        }
    }

    public static void main(String[] args){
        Test test = new Test();

        new Thread(()->test.m(),"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->test.m(),"t2").start();
    }

}
