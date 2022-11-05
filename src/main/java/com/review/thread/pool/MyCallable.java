package com.review.thread.pool;

import java.util.concurrent.Callable;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/05 16:44
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1);
        return Thread.currentThread().getName();
    }
}
