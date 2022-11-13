package com.review.loader;

/**
 * @program java-review-demo
 * @description: classloader
 * @author: xuyaxi
 * @create: 2022/11/09 22:44
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        System.out.println("ClassLoaderDemo's classloader is:" + ClassLoaderDemo.class.getClassLoader());
        System.out.println("ClassLoaderDemo's classloader name is:" + ClassLoaderDemo.class.getClassLoader().getName());
        System.out.println("The parent of ClassLoaderDemo's classloader is:" + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The grandParent of ClassLoaderDemo's classloader is:" + ClassLoaderDemo.class.getClassLoader().getParent().getParent());

    }
}
