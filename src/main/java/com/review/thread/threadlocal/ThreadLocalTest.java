package com.review.thread.threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/07 19:57
 */
public class ThreadLocalTest {

    private List<String> msg = new ArrayList<>();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String msg){

        holder.get().msg.add(msg);
    }

    public static List<String> clear(){
        List<String> list = holder.get().msg;
        holder.remove();
        System.out.println("size:" + holder.get().msg.size());
        return list;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("abracadabra");
        System.out.println(holder.get().msg);
        ThreadLocalTest.clear();
    }


}
