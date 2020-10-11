package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/11
 */

public class Q0416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for(int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if(maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        dp[0][nums[0]] = true;
        dp[0][0] = true;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if(nums[i] <= j) {
                    dp[i][j] |= dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][target];
    }
}
