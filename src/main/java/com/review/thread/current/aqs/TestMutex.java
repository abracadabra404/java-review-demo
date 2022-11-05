package com.review.thread.current.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/05 15:02
 */
public class TestMutex {

    private static CyclicBarrier barrier = new CyclicBarrier(31);
    private static int a = 0;
    private static int threadCount = 30;
    private static int addCount = 10000;
    private static Mutex mutex = new Mutex();

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < addCount; i1++) {
                        increment1();
                    }
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.start();
        }
        barrier.await();
        System.out.println("加锁前：a=" + a);
        barrier.reset();
        a = 0;
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < addCount; i1++) {
                        increment2();
                    }
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.start();
        }
        barrier.await();
        System.out.println("加锁后：a=" + a);
    }

    private static void increment2() {
        mutex.lock();
        a++;
        mutex.unlock();
    }

    private static void increment1() {
        a++;
    }
}
