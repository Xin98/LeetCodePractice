package cn.codexin.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/7/3
 */

public class Q0451_Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (char c : s.toCharArray()) {
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuilder[] buckets = new StringBuilder[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuilder();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            buckets[entry.getValue()].append(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int freq = maxFreq; freq >= 0; freq--) {
            for (char c : buckets[freq].toString().toCharArray()) {
                for (int i = 0; i < freq; i++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
