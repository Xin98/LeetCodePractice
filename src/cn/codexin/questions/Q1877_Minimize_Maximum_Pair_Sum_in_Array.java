package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/7/20
 */

public class Q1877_Minimize_Maximum_Pair_Sum_in_Array {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n / 2; i++) {
            ans = Math.max(ans, nums[i] + nums[n - 1 - i]);
        }
        return ans;
    }
}
