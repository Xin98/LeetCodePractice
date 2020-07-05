package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/5
 */

public class Q0044_Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for (int i = 1; i <= pLen; i++) {
            if(p.charAt(i-1) == '*') {
                dp[0][i] = true;
            } else{
                break;
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*' && (dp[i][j-1] || dp[i-1][j])){
                    dp[i][j] = true;
                }
            }

        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        Q0044_Wildcard_Matching Q = new Q0044_Wildcard_Matching();
        Q.isMatch("adceb", "*a*b");
    }
}
