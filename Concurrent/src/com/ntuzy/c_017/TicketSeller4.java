package com.ntuzy.c_017;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class TicketSeller4 {

    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for (int i = 0; i < 1000; i++) {
//            tickets.add(null);
            tickets.add("编号" + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                while (true) {
                    String s = tickets.poll();
                    if (s == null) break;
                    else System.out.println("销售了 -- " + s);

                }

            }).start();
        }

    }

}
