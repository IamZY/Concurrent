package com.ntuzy.c_019;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池中的每个线程都维护一个任务队列
 * 如果一个线程的任务执行完成的时候 空闲的线程会执行另外没有执行完任务的线程的中队列的任务
 */
public class T11_WorkStealingPool {

    public static void main(String[] args) throws IOException {

        ExecutorService service = Executors.newWorkStealingPool();

        System.out.println(Runtime.getRuntime().availableProcessors());

        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));

        // 精灵线程  主线程不阻塞的话 看不到输出

        System.in.read();

    }


    static class R implements Runnable {

        int time;

        public R(int time) {
            this.time = time;
        }


        @Override
        public void run() {

            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(time + " " + Thread.currentThread().getName());

        }

    }


}
