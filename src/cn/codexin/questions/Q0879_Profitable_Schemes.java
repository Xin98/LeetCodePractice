package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/9
 */

public class Q0879_Profitable_Schemes {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int len = group.length, MOD = (int)1e9 + 7;

        for (int i = 1; i <= len; i++) {
            int crime = group[i - 1], money = profit[i - 1];
            for (int j = n; j >= crime; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - crime][Math.max(0, k - money)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }
}
