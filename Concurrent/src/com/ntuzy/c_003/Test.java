package com.ntuzy.c_003;

public class Test {
    private static int count = 10;


    public static void m() {
        synchronized (Test.class) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }


    // 等价上面的m函数  锁定的是对象 不是代码块
    public static synchronized void m1() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }


}
