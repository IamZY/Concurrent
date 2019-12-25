package com.ntuzy.c_018;

import java.util.concurrent.LinkedTransferQueue;

/**
 *     // 如果可能，立即将元素转移给等待的消费者。
 *     // 更确切地说，如果存在消费者已经等待接收它（在 take 或 timed poll（long，TimeUnit）poll）中，则立即传送指定的元素，否则返回 false。
 *     boolean tryTransfer(E e);
 *
 *     // 将元素转移给消费者，如果需要的话等待。
 *     // 更准确地说，如果存在一个消费者已经等待接收它（在 take 或timed poll（long，TimeUnit）poll）中，则立即传送指定的元素，否则等待直到元素由消费者接收。
 *     void transfer(E e) throws InterruptedException;
 *
 *     // 上面方法的基础上设置超时时间
 *     boolean tryTransfer(E e, long timeout, TimeUnit unit) throws InterruptedException;
 *
 *     // 如果至少有一位消费者在等待，则返回 true
 *     boolean hasWaitingConsumer();
 *
 *     // 返回等待消费者人数的估计值
 *     int getWaitingConsumerCount();
 */
public class T08_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
        
        new Thread(()-> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa");


//        new Thread(()->{
//
//            try {
//                System.out.println(strs.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();

    }
    
}
