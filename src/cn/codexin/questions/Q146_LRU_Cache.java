package cn.codexin.questions;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/4/1
 */

public class Q146_LRU_Cache {

    private Map<Integer, Integer> data;
    public Q146_LRU_Cache(int capacity) {
        data = new LinkedHashMap<Integer, Integer>((int)(capacity / 0.75f), 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if(data.size() > capacity) return true;
                return false;
            }
        };
    }
    public int get(int key) {
        int value = data.getOrDefault(key, -1);
        return value;
    }
    public void put(int key, int value) {
        data.put(key, value);
    }
    public static void main(String[] args) {
        Q146_LRU_Cache q146_lru_cache = new Q146_LRU_Cache(3);
        q146_lru_cache.put(1,1);
        q146_lru_cache.put(2,2);
        q146_lru_cache.put(4,2);
        q146_lru_cache.put(6,2);
        q146_lru_cache.put(3,3);
        System.out.println(q146_lru_cache.get(4));
    }
}
