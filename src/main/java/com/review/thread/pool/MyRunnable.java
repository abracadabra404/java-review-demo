package com.review.thread.pool;

import java.time.LocalDateTime;

/**
 * @program nio-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/02 16:59
 */
public class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start,time=" + LocalDateTime.now());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " end,time=" + LocalDateTime.now());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                '}';
    }
}
