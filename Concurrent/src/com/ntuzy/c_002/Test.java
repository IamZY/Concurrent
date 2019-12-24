package com.ntuzy.c_002;

public class Test {
    private int count = 10;


    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }


    // 等价上面的m函数  锁定的是对象 不是代码块
    public synchronized void m1() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }


}
