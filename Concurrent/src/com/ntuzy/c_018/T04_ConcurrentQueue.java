package com.ntuzy.c_018;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            strs.offer("a" + i);  // add
        }

        System.out.println(strs);
        System.out.println(strs.size());
        System.out.println(strs.poll());   // 从首部提取一个 并 删除
        System.out.println(strs.size());
        System.out.println(strs.peek());  // 从首部提取一个  但 不删除
        System.out.println(strs.size());

        
//        System.out.println(T04_ConcurrentQueue.class);
//        System.out.println(this);

    }

}
