package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/7/8
 */

public class Q0930_Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            int cnt = sumMap.getOrDefault(sum - goal, 0);
            ans += cnt;
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
