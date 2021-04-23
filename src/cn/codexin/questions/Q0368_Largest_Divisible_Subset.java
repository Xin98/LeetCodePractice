package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/4/23
 */

public class Q0368_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxValue = 0, maxSize = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[j] == j + 1) {
                        break;
                    }
                }
            }
            if(dp[i] > maxSize) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }
        List<Integer> ans = new LinkedList<>();
        if(maxSize == 1) {
            ans.add(nums[0]);
            return ans;
        }
        for (int i = n; i >= 0; i--) {
            if(dp[i] == maxSize && maxValue % nums[i] == 0) {
                ans.add(nums[i]);
                maxSize--;
                maxValue = nums[i];
            }
        }
        return ans;
    }
}
