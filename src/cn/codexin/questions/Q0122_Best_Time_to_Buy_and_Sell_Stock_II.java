package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/9
 */

public class Q0122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int ans = 0;
        for(int i = 1; i < len; i++) {
            if(prices[i] > prices[i-1]) {
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}
