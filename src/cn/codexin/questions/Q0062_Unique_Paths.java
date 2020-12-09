package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/12/9
 */

public class Q0062_Unique_Paths {
    public int uniquePaths(int m, int n) {
        if(m > n) {
            return uniquePaths(n, m);
        }
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[m - 1];
    }
}
