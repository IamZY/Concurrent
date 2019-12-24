package com.ntuzy.c_006;

import java.util.concurrent.TimeUnit;

public class Account {

    String name;
    double price;


    // 锁住的同时可以被非锁住的方法进行执行  产生脏读
    // 只是对写加锁 但是没有对读操作进行加锁  读到在写的过程中没有完成的数据
    public synchronized void set(String name,double price) {
        this.name = name;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.price = price;
    }

    public /*synchronized*/ double getPrice(String name) {
        return price;
    }

    public static void main(String[] args){
        Account a = new Account();

        new Thread(()->a.set("zhangsan",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getPrice("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getPrice("zhangsan"));
    }



}
