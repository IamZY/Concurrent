package com.ntuzy.c_018;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 简单来说，就是平时查询的时候，都不需要加锁，随便访问，只有在写入/删除的时候，
 * 才会从原来的数据复制一个副本出来，然后修改这个副本，最后把原数据替换成当前的副本。
 * 修改操作的同时，读操作不会被阻塞，而是继续读取旧的数据。这点要跟读写锁区分一下。
 *
 * CopyOnWrite
 *
 */
public class T02_CopyOnWriteList {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
        List<String> list = new Vector<>();
//        List<String> list = new CopyOnWriteArrayList<>();


        Random r = new Random();
        Thread[] ths = new Thread[100];

        for (int i = 0; i < ths.length; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        list.add("a" + r.nextInt(10000));
                    }
                }
            };

            ths[i] = new Thread(task);

        }

        runAndComputeTime(ths);

        System.out.println(list.size());
    }


    static void runAndComputeTime(Thread[] ths) {
        long start = System.currentTimeMillis();

        Arrays.asList(ths).forEach(t->t.start());


        Arrays.asList(ths).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


}
