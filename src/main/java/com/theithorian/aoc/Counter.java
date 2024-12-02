package com.theithorian.aoc;

import java.util.HashMap;
import java.util.Map;

public class Counter<T> {
    private Map<T, Integer> countMap = new HashMap<T, Integer>();

    public void add(T key) {
        Integer count = countMap.containsKey(key) ? countMap.get(key) : 0;
        countMap.put(key, count + 1);
    }

    public Integer getCount(T key) {
        Integer count = countMap.containsKey(key) ? countMap.get(key) : 0;
        return count;
    }

}
