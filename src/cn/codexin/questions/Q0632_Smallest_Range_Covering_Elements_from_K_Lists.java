package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/8/1
 */

public class Q0632_Smallest_Range_Covering_Elements_from_K_Lists {
    public int[] smallestRange(List<List<Integer>> nums) {
        // (elements, belonging list indexes)
        Map<Integer, List<Integer>> indices = new HashMap<>();
        int n = nums.size();
        // range of nums
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> sigleNums = nums.get(i);
            for (Integer sigleNum : sigleNums) {
                List<Integer> list = indices.getOrDefault(sigleNum, new LinkedList<>());
                list.add(i);
                indices.putIfAbsent(sigleNum, list);
                min = Math.min(min, sigleNum);
                max = Math.max(max, sigleNum);
            }
        }
        int left = min;
        int right = min - 1;
        // recorder answer of range
        int bestLeft = min;
        int bestRight = max;
        // recorder each times of nums's list index
        int[] freq = new int[n];
        // count unique list's index.
        int count = 0;
        while(right < max) {
            right++;
            if(!indices.containsKey(right)) {
                continue;
            }
            for (Integer index : indices.get(right)) {
                freq[index]++;
                if(freq[index] == 1) {
                    count++;
                }
            }
            while (count == n) {
                if(right - left < bestRight - bestLeft) {
                    bestRight = right;
                    bestLeft = left;
                }
                if(indices.containsKey(left)) {
                    for (Integer index : indices.get(left)) {
                        freq[index]--;
                        if(freq[index] == 0) {
                            count--;
                        }
                    }
                }
                left++;
            }
        }
        return new int[]{bestLeft, bestRight};
    }

    public static void main(String[] args) {
        Q0632_Smallest_Range_Covering_Elements_from_K_Lists Q = new Q0632_Smallest_Range_Covering_Elements_from_K_Lists();
        List<List<Integer>> nums = new LinkedList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));
        Q.smallestRange(nums);
    }
}
