package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/17
 */

public class Q0714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for(int i = 1; i < n; i++) {
            int tmp = dp[0];
            // 第 i 天 不持有
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            // 第 i 天 持有
            dp[1] = Math.max(dp[1], tmp - prices[i]);
        }
        return dp[0];
    }
}
