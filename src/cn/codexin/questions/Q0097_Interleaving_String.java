package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/18
 */

public class Q0097_Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if(n + m != t) {
            return false;
        }
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if(i > 0) {
                    dp[j] &= s1.charAt(i-1) == s3.charAt(p);
                }
                if(j > 0) {
                    dp[j] |= dp[j-1] && s2.charAt(j-1) == s3.charAt(p);
                }
            }
        }
        return dp[m];
    }
}
