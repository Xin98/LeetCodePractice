package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/3/17
 */

public class Q0115_Distinct_Subsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(n == 0) {
            return 1;
        }
        if(m == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            char tc = t.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(j - 1);
                if(tc == sc) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }

            }
        }
        return dp[n][m];

    }
}
