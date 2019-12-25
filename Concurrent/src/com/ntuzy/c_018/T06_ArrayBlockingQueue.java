package com.ntuzy.c_018;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {

    static BlockingQueue<String> strs = new ArrayBlockingQueue<String>(10);

    static Random r = new Random();


    public static void main(String[] args) throws InterruptedException {
        for(int i = 0;i < 10;i++) {
            strs.put("a" + i);
        }

//        strs.put("aaa");  // 容器满了  再添加会阻塞
//        strs.offer("aaa");  // 容器满了  有返回值 满了返回fasle
        strs.add("aaa");  // 容器满了 抛出异常

//        strs.offer("aaa",1,TimeUnit.SECONDS);

        System.out.println(strs);
    }

}
