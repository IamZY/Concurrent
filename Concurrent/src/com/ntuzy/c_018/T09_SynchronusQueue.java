package com.ntuzy.c_018;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 特殊TransferQueue 容量为0
 *
 * 同步队列，是一个容量为 0 的队列。 是一个特殊的 TransferQueue。
 * 必须现有消费线程等待，才能使用的队列。
 *
 *     add 方法，无阻塞。若没有消费线程阻塞等待数据，则抛出异常。
 *     put 方法，有阻塞。若没有消费线程阻塞等待数据，则阻塞。
 *
 */
public class T09_SynchronusQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa");   // 阻塞等待消费者消费
        System.out.println(strs.size());
    }
}
