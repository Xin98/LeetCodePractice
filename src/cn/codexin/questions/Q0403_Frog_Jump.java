package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/29
 */

public class Q0403_Frog_Jump {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if(k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
                if(i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
