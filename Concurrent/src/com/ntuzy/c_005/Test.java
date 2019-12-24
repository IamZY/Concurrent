package com.ntuzy.c_005;

/**
 * 一个方法在锁住的同时 其他没有加锁的方法也可以继续被执行
 *  因为m2方法执行的过程中不考虑锁的问题 所以互补干扰
 *
 */
public class Test {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start ...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end ... ");
    }

    public /*synchronized*/ void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        Test test = new Test();

        new Thread(() -> test.m1(), "t1").start();
        new Thread(() -> test.m2(), "t2").start();
    }


}
