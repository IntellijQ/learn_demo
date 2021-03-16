package com.learn.jvm.jdk8;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author yds
 * @title: LRU
 * @description: TODO
 * @date 2021/3/10 10:09
 */
public class LRU {
    Integer size = 0;
    Integer maxSize = 3;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    LinkedList<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.set(1,1);
        lru.set(2,2);
        lru.set(3,3);
        lru.set(4,4);
        lru.set(5,5);
        lru.set(6,6);

        System.out.println(JSON.toJSONString(lru.map));
        System.out.println(JSON.toJSONString(lru.linkedList));
    }


    public void set(Integer key, Integer value) {
        // 达到最大容量后，需淘汰最后的数据
        if(size == maxSize){
            Integer removeLastKey = linkedList.removeLast();
            map.remove(removeLastKey);
            size--;
            System.out.println("淘汰数据" + removeLastKey);
        }

        linkedList.addFirst(key);
        map.put(key, value);
        size++;
    }

    public void get(Integer key) {
        Integer value = map.get(key);
        if(value != null){
            linkedList.remove(key);
            linkedList.addFirst(key);
            System.out.println("活跃数据放头部" + key);
        }
    }
}
