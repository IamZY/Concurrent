package com.ntuzy.c_014;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  ReentrantLock 公平锁  谁等的时间长 选择哪个线程
 */
public class ReentrantLock3 extends Thread {

    private static ReentrantLock reentrantLock = new ReentrantLock(true);


    @Override
    public void run() {
        for(int i = 0;i < 100;i++) {
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获得锁 ");
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args){

        ReentrantLock3 reentrantLock3 = new ReentrantLock3();

        Thread thread1 = new Thread(reentrantLock3);
        Thread thread2 = new Thread(reentrantLock3);

        thread1.start();
        thread2.start();

    }
    
}
