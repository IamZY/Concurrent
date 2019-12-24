package com.ntuzy.c_011;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile 和 synchronized 区别
 */
public class Test {

//    volatile int count = 0;
//
//    void m() {
//        for (int i = 0; i < 10000; i++) {
//            count++;
//        }
//    }

    AtomicInteger count = new AtomicInteger(0);

    /*synchronized*/ void m() {
        for(int i = 0;i < 10000;i++) {
            // if count.get() < 1000  // Atomic类之间的方法不保证原子性
            count.incrementAndGet(); // 保证原子性  替代count++
        }
    }


    public static void main(String[] args) {
        Test test = new Test();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> test.m(), "thread-" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(test.count);
        
    }


}
