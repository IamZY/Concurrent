package com.ntuzy.c_001;

public class Test {

    private int count = 10;
    private Object o = new Object();


    public void m() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}
