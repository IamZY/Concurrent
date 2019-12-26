package com.ntuzy.c_019;

import java.util.concurrent.Executor;

public class T01_MyExecutor implements Executor {

    public static void main(String[] args){
        new T01_MyExecutor().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello executor");
            }
        });
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
