package com.review.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program nio-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/02 17:12
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args){
      //
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for(int i = 0; i < 10; i++) {
          //
            MyRunnable worker = new MyRunnable("" + i);
            poolExecutor.execute(worker);
        }
        poolExecutor.shutdown();
        while (!poolExecutor.isTerminated()){}
        System.out.println("finished all threads");
    }
}
