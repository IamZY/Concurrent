package com.ntuzy.c_004;

public class Test implements Runnable {
    private int count = 10;

    // 原子操作 在执行过程中不可以被打断
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 0; i < 5; i++) {
            new Thread(test, "Thread" + i).start();
        }
    }

}
