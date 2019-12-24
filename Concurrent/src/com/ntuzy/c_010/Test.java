package com.ntuzy.c_010;

import java.util.concurrent.TimeUnit;

/**
 * volatile 关键字  线程之间的可见性
 * Java 线程模型  JMM
 */
public class Test {

    volatile boolean running = true;

    void m() {
        System.out.println(" m start ");
        while (running) {

        }
        System.out.println(" m end ");
    }

    public static void main(String[] args) {
        Test test = new Test();

        new Thread(() -> test.m()).start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.running = false;

    }


}
