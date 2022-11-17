package com.review.data;

import java.util.BitSet;

/**
 * @program java-review-demo
 * @description: 布隆过滤器
 * @author: xuyaxi
 * @create: 2022/11/17 21:44
 */
public class MyBloomFilter {

    private static final int DEFAULT_SIZE=2<<24;

    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    public SimpleHash[] funs = new SimpleHash[SEEDS.length];

    public MyBloomFilter(){
        for (int i = 0; i < SEEDS.length; i++) {
            funs[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    public void add(Object value) {
        for (SimpleHash fun :
                funs) {
            bits.set(fun.hash(value), true);
        }
    }

    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash fun :
                funs) {
            ret = ret && bits.get(fun.hash(value));
        }
        return ret;
    }

    public static class SimpleHash{
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & (h = value.hashCode()) ^ (h >>> 16));
        }
    }

    public static void main(String[] args) {
        String value1 = "abracadabra";
        String value2 = "xvyaxi";
        MyBloomFilter bloomFilter = new MyBloomFilter();
        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));
        bloomFilter.add(value1);
        bloomFilter.add(value2);
        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));
    }


}
