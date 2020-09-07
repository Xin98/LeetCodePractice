package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/9/7
 */

public class Q0347_Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        return quickSearch(values, 0, values.size() - 1, k - 1);
    }

    private int[] quickSearch(List<int[]> values, int lo, int hi, int k) {
        int j = partition(values, lo, hi);
        if(j == k) {
            int[] ans = new int[k+1];
            for (int i = 0; i <= k; i++) {
                ans[i] = values.get(i)[0];
            }
            return ans;
        }
        return j > k ? quickSearch(values, lo, j - 1, k) : quickSearch(values, j + 1, hi, k);
    }

    private int partition(List<int[]> values, int lo, int hi) {
        int v = values.get(lo)[1];
        int i = lo, j = hi + 1;
        while (true) {
            while(++i <= hi && values.get(i)[1] >= v);
            while(--j >= lo && values.get(j)[1] < v);
            if(i >= j) {
                break;
            }
            Collections.swap(values, i, j);
        }
        Collections.swap(values, lo, j);
        return j;
    }
}
