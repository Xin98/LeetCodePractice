package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/28
 */

public class Q0188_Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0 || k == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        for(int i = 1; i <= k; i++) {
            dp[0][1] = -prices[0];
            for(int j = 1; j < n; j++) {
                dp[j][1] = Math.max(dp[j - 1][1], dp[j][0] - prices[j]);
                dp[j][0] = Math.max(dp[j - 1][1] + prices[j], dp[j - 1][0]);
            }
        }
        return dp[n - 1][0];
    }
}
