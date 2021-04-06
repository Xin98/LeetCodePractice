package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/3
 */

public class Q1143_Longest_Common_Subsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            char a = text1.charAt(i-1);
            for(int j = 1; j <= m; j++){
                char b = text2.charAt(j-1);
                if(a == b){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
