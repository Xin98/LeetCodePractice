package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/10
 */

public class Q0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }
        //dp[i][0] 目前持有一只股票的最大收益
        //dp[i][1] 目前不持有股票处于冷冻期的最大收益
        //dp[i][2] 目前不持有股票不处于冷冻期的最大收益
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] =  dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        //最后一天持有股票显然无意义
        return Math.max(dp[n-1][1], dp[n-1][2]);

    }
}
