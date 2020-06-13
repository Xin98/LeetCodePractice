package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/13
 */

public class Q0070_Climbing_Stairs {
    public int climbStairs(int n) {
        int[] dp = new int[2];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = dp[1];
            dp[1] += dp[0];
            dp[0] = tmp;
        }
        return dp[1];
    }
}
