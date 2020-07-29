package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/30
 */

public class Q0343_Integer_Break {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i-j], i-j));
            }
        }
        return dp[n];
    }
}
