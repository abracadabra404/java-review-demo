package com.review.thread.pool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/05 16:45
 */
public class ThreadPoolCallableDemo {

    private static final int CORE_POOL_SIZE=3;
    private static final int MAX_POOL_SIZE=5;
    private static final int QUEUE_CAPACITY=100;
    private static final Long KEEP_ALIVE_TIME=1L;

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        List<Future<String>> futureList = new ArrayList<>();
        MyCallable myCallable = new MyCallable();

        for (int i = 0; i < 10; i++) {
            Future<String> future = poolExecutor.submit(myCallable);
            futureList.add(future);
        }
        futureList.stream().forEach(future -> {
            try {
                System.out.println(LocalDateTime.now() + "::" + future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        poolExecutor.shutdown();
    }
}
