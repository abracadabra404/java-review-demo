package com.review.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program nio-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/01 20:19
 */
public class VolatileDemo {

    public static  int i = 0;
    ReentrantLock lock = new ReentrantLock();
    public void increase(){
        lock.lock();
        try{
            i ++;
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
      //
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileDemo volatileDemo = new VolatileDemo();
        for(int j = 0; j < 5; j++) {
          threadPool.execute(() -> {
              for(int k = 0; k < 500; k++) {
                volatileDemo.increase();
              }
          });
        }
        Thread.sleep(1500);
        System.out.println(i);
        threadPool.shutdown();
    }


}
