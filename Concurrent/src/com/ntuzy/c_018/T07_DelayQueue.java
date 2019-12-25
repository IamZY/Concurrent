package com.ntuzy.c_018;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务
 */
public class T07_DelayQueue {
    static BlockingQueue<MyTask> tasks = new DelayQueue();

    static Random r = new Random();

    static class MyTask implements Delayed {

        long runningTime;

        MyTask(long rt) {
            this.runningTime = rt;
        }


        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else {
                return 0;
            }
        }

        public String toString() {
            return "" + runningTime;
        }

        public static void main(String[] args) throws InterruptedException {
            long now = System.currentTimeMillis();

            MyTask task1 = new MyTask(now + 1000);
            MyTask task2 = new MyTask(now + 2000);
            MyTask task3 = new MyTask(now + 1500);
            MyTask task4 = new MyTask(now + 2500);
            MyTask task5 = new MyTask(now + 500);


            tasks.put(task1);
            tasks.put(task2);
            tasks.put(task3);
            tasks.put(task4);
            tasks.put(task5);

            System.out.println(tasks);

            for (int i = 0; i < 5; i++) {
                System.out.println(tasks.take());
            }

        }

    }

}
