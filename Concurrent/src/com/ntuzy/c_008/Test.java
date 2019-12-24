package com.ntuzy.c_008;

import java.util.concurrent.TimeUnit;

public class Test {

    public synchronized void m1() {
        System.out.println(" m1 start ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" m end ");
    }


    public static void main(String[] args){
        new Test2().m1();
    }

}


class Test2 extends Test {

    @Override
    public synchronized void m1() {
        System.out.println("child m1 start .. ");
        super.m1();
        System.out.println("child m1 end .. ");
    }
}