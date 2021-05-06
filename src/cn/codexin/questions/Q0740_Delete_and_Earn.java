package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/5/5
 */

public class Q0740_Delete_and_Earn {
    public int deleteAndEarn(int[] nums) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int[] dp = new int[maxValue + 1];
        int[] cnt = new int[maxValue + 1];
        for(int num : nums) {
            cnt[num]++;
        }
        dp[1] = cnt[1];
        for(int i = 2; i <= maxValue; i++) {
            dp[i] = Math.max(dp[i - 2] + cnt[i] * i, dp[i - 1]);
        }
        return dp[maxValue];
    }
}
