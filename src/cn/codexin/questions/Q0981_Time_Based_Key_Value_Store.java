package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xinGao 2021/7/10
 */

public class Q0981_Time_Based_Key_Value_Store {
    class TimeMap {

        Map<String, TreeMap<Integer, String>> map;
        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treeMap = map.get(key);
            if(treeMap == null) {
                return "";
            }
            Integer time = treeMap.floorKey(timestamp);
            if(time == null) {
                return "";
            }
            return treeMap.get(time);
        }
    }
}
