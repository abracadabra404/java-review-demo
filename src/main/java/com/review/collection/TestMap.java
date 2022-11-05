package com.review.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program nio-demo
 * @description: 集合
 * @author: xuyaxi
 * @create: 2022/10/29 16:44
 */
public class TestMap {

  public static void main(String[] args) {
    //
    Map<Integer,String> map = new HashMap();

    map.put(null, "Java");
    map.put(null, "PHP");
    map.put(3, "GO");
    map.put(4, "python");
    Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()){
      Map.Entry<Integer, String> next = iterator.next();
      System.out.println(next.getKey());
      System.out.println(next.getValue());
    }
//    Iterator<Integer> iterator = map.keySet().iterator();
//    while (iterator.hasNext()){
//      Integer next = iterator.next();
//      System.out.println(next);
//      System.out.println(map.get(next));
//    }
//    for (Map.Entry<Integer,String> entry : map.entrySet()){
//      System.out.println(entry.getKey());
//      System.out.println(entry.getValue());
//    }
//    map.forEach((key,value) -> {
//      System.out.println(key);
//      System.out.println(value);
//    });
  }
}
