package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/4/24
 */

public class Q0377_Combination_Sum_IV {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < n; j++) {
                if(i < nums[j]) {
                    break;
                }
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];

    }
}
