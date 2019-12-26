package com.ntuzy.c_019;

import java.util.concurrent.*;

/**
 * 一个Future代表一个异步计算的结果。Future提供检查计算是否完成、等待计算完成并获取计算结果的方法。
 * 只有当计算完成以后，才可以使用get方法检索结果，否则将会阻塞直到计算完成。通过调用cancel方法可以取消执行。
 * 另外，还提供了检查任务是正常完成还是被取消的方法。一旦计算完成，这个计算不能被取消。
 */
public class T06_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(() -> {
            TimeUnit.MICROSECONDS.sleep(500);
            return 1000;
        });


        new Thread(task).start();

        System.out.println(task.get());  // 阻塞

        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<Integer> f = service.submit(() -> {
            TimeUnit.MICROSECONDS.sleep(500);
            return 1;
        });

        System.out.println(f.get());
        System.out.println(f.isDone());  // 计算是否完成
//        System.out.println(f.get());
//        System.out.println(f.isDone());

//        f.cancel(cancel)

        service.shutdown();

    }
}
