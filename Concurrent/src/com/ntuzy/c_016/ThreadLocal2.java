package com.ntuzy.c_016;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal 自己的线程用自己的 空间换时间
 */
public class ThreadLocal2 {

    static ThreadLocal<Person> tl = new ThreadLocal();

    public static void main(String[] args){

        new Thread(()-> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();

    }

    static class Person {
        String name = "zhangsan";
    }



}
