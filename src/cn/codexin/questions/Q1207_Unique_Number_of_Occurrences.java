package cn.codexin.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xinGao 2020/10/28
 */

public class Q1207_Unique_Number_of_Occurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        Set<Integer> freqSet = new HashSet<>();
        for(int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if(freqSet.contains(entry.getValue())) {
                return false;
            }
            freqSet.add(entry.getValue());
        }
        return true;
    }
}
