package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/15
 */

public class Q0096_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
