package com.review.thread;

/**
 * @program java-review-demo
 * @description: 死锁
 * @author: xuyaxi
 * @create: 2022/11/12 19:03
 */
public class DeadLockDemo {

    private static Object resource1 = new Object();
    private static Object resource2 = new Object();


    public static void main(String[] args) {
        new Thread(()-> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        },"thread 1").start();
        new Thread(()->{
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        },"thread 2").start();
    }


}
