package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/21
 */

public class Q0746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < n; i++) {
            int tmp = dp[1];
            dp[1] = cost[i] + Math.min(dp[0], dp[1]);
            dp[0] = tmp;
        }
        return Math.min(dp[0], dp[1]);
    }
}
