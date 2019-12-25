package com.ntuzy.c_015;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者
 *
 * @param <T>
 */
public class MyContainer1<T> {

    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;

    private int count = 0;


    public synchronized void put(T t) {
        while (lists.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        this.notifyAll();  // 通过消费者线程进行消费 notify可能只会唤醒生产者线程 再次wait
    }

    public synchronized T get() {
        T t = null;

        while (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t = lists.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {

        MyContainer1<String> container = new MyContainer1();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(container.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            int x = i;
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    container.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }


    }

}
