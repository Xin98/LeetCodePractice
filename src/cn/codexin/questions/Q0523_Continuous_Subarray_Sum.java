package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/6/2
 */

public class Q0523_Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n < 2) {
            return false;
        }
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < n; i++) {
            remainder = (remainder + nums[i]) % k;
            if(pos.containsKey(remainder)) {
                if(i - pos.get(remainder) >= 2) {
                    return true;
                }
            } else {
                pos.put(remainder, i);
            }
        }
        return false;
    }
}
