package com.ntuzy.c_014;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 必须手动释放锁
 */
public class ReentrantLock1 {

    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 必须手动释放
            lock.unlock();
        }

    }


    void m2() {
        lock.lock();
        System.out.println("m2 ... ");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock1 r1 = new ReentrantLock1();

        new Thread(() -> {
            r1.m1();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2).start();

    }


}
