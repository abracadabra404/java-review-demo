package com.review.data;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import java.util.logging.Filter;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/17 22:12
 */
public class TestGuavaBloomFilter {

    public static void main(String[] args) {
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1500, 0.01);
        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(4));
        bloomFilter.put(2);
        bloomFilter.put(4);
        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(4));

    }
}
