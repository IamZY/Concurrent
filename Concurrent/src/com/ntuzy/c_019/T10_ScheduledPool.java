package com.ntuzy.c_019;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时器线程池
 */
public class T10_ScheduledPool {
    public static void main(String[] args){

        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        // 以固定的频率执行任务
        // initialDelay 第一次执行的时间
        // period 任务执行频率
        service.scheduleAtFixedRate(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName());

        },0,500,TimeUnit.MILLISECONDS);

    }

}
