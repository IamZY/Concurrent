package com.ntuzy.c_019;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class T05_ThreadPool {
    
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(5);   // 线程池 5个线程

        for(int i = 0;i < 6;i++) {
            // execute submit
            // 线程池中的线程执行的任务  5个线程执行6个任务
            service.execute(()->{
                try {
                    TimeUnit.MICROSECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        
        System.out.println(service);
        
        service.shutdown();  // 线程池的关闭  等待任务做完关闭
        System.out.println(service.isTerminated());  // 所有执行的任务有没有执行完
        System.out.println(service.isShutdown());  // 线程池是不是关闭了
        System.out.println(service);
        
        TimeUnit.SECONDS.sleep(5);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);


    }


    
    
}
