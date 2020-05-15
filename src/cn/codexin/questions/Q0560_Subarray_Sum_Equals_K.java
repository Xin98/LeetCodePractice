package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/5/15
 */

public class Q0560_Subarray_Sum_Equals_K {
    // hash + 前缀和 时间O(n) 空间O(n)
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);
        int preSum = 0, ans = 0;
        for(int num : nums) {
            preSum += num;
            if(preSumFreq.containsKey(preSum - k)) ans += preSumFreq.get(preSum - k);
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
