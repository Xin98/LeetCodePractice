package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/13
 */

public class Q1269_Number_of_Ways_to_Stay_in_the_Same_Place_After_Some_Steps {
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(steps, arrLen);
        int[][] dp = new int[steps + 1][arrLen];
        dp[0][0] = 1;
        int mod = 1000000007;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < arrLen; j++) {
                dp[i][j] = dp[i - 1][j] % mod;
                if(j != 0) {
                    dp[i][j] += dp[i - 1][j - 1] % mod;
                    dp[i][j] %= mod;
                }
                if(j != arrLen - 1) {
                    dp[i][j] += dp[i - 1][j + 1] % mod;
                    dp[i][j] %= mod;
                }
            }
        }
        return dp[steps][0];
    }
}
