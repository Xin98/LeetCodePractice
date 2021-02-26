package cn.codexin.questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by xinGao 2021/2/26
 */

public class Q1178_Number_of_Valid_Words_for_Each_Puzzle {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);
        }
        List<Integer> ans = new LinkedList<>();
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for(int i = 1; i < 7; i++) {
                mask |= (1 << puzzle.charAt(i) - 'a');
            }
            int subSet = mask;
            do {
                int s = subSet | (1 << puzzle.charAt(0) - 'a');
                if(freq.containsKey(s)) {
                    total += freq.get(s);
                }
                subSet = (subSet - 1) & mask;
            } while (subSet != mask);
            ans.add(total);
        }
        return ans;
    }
}
