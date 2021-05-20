package cn.codexin.questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xinGao 2021/5/20
 */

public class Q0692_Top_K_Frequent_Words {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        Queue<String> minHeap = new PriorityQueue<>((s1, s2)-> {
            if(cnt.get(s1).equals(cnt.get(s2))) {
                return s2.compareTo(s1);
            } else {
                return cnt.get(s1) - cnt.get(s2);
            }
        });
        for (String word : cnt.keySet()) {
            minHeap.offer(word);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> ans = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
