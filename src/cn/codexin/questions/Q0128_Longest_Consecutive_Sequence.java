package cn.codexin.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xinGao 2020/6/6
 */

public class Q0128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            if(set.contains(num-1)) continue;
            int next = num;
            while (set.contains(next)) {
                next++;
            }
            ans = Math.max(ans, next - num);
        }
        return ans;
    }
}
