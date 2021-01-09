package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/9
 */

public class Q0123_Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j < n; j++) {
                buy[j] = Math.max(buy[j-1], sell[j] - prices[j]);
                sell[j] = Math.max(sell[j-1], buy[j-1] + prices[j]);
            }
        }
        return sell[n-1];

    }
}
