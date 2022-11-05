package com.review.pattern;

/**
 * @program nio-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/01 20:07
 */
public class Singleton {


    public volatile static Singleton singleton;

    private Singleton(){}

    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;

    }


}
