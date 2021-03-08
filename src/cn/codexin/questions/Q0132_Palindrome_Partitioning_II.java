package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/3/8
 */

public class Q0132_Palindrome_Partitioning_II {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] f = new int[n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        Arrays.fill(f, Integer.MAX_VALUE);
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        for(int i = 0; i < n; i++) {
            if(dp[0][i]) {
                f[i] = 0;
            } else {
                for(int j = 0; j < i; j++) {
                    if(dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }

        }
        return f[n - 1];
    }
}
