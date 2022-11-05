package com.review.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/05 16:35
 */
public class ThreadPoolSubmitDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<String> submit = service.submit(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "abc";
        });
        System.out.println("get:" + submit.get() + ",isDone:" + submit.isDone() + ",isCancelled:" + submit.isCancelled());
        System.out.println("service is terminated:" + service.isTerminated() + ",is shutdown:" + service.isShutdown());
        service.shutdown();
        //Thread.sleep(5);
        System.out.println("service is terminated:" + service.isTerminated() + ",is shutdown:" + service.isShutdown());
    }

}
