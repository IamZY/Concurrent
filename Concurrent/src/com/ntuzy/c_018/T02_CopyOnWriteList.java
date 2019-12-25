package com.ntuzy.c_018;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

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
