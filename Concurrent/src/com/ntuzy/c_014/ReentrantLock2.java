package com.ntuzy.c_014;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * interrupt
 */
public class ReentrantLock2 {

    public static void main(String[] args){
        Lock lock = new ReentrantLock();


        new Thread(()->{

            lock.lock();

            try {

                System.out.println(" t1 start ");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println(" t1 end ");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();


        Thread t2 = new Thread(()-> {
//            lock.lock(); //

            try {
                lock.lockInterruptibly(); // 可以堆interrupt()方法做出回应
                System.out.println(" t2 start ");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(" t2 interrupted!");
            } finally {
                lock.unlock();
            }

        });

        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();  // 打断线程2的等待



    }
    
}
