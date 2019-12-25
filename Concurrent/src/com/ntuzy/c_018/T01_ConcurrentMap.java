package com.ntuzy.c_018;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class T01_ConcurrentMap {

    public static void main(String[] args) {

//        Map<String, String> map = new Hashtable<>();  // 加锁
//        Map<String, String> map = new ConcurrentHashMap<>();   // lock 将容器分成16段 每次插入只锁定其中一个部分 多线程时候可以同时并发往里面插入数据

//        Map<String, String> map = new HashMap<>();


//        Map<String, String> map = new TreeMap<>();
        Map<String, String> map = new ConcurrentSkipListMap<>();  // 高并发并且排序的情况下

//        Collections.synchronizedMap()  // 将不带锁的map传入  返回带锁的map

        Random r = new Random();

        Thread[] ths = new Thread[100];

        CountDownLatch latch = new CountDownLatch(ths.length);

        long start = System.currentTimeMillis();

        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    map.put("a" + r.nextInt(10000), "a" + r.nextInt(10000));
                    latch.countDown();
                }
            });
        }


        Arrays.asList(ths).forEach(t -> t.start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

}
