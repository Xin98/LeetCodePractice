package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/20
 */

public class Q0010_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for(int i = 0; i <= sLen; i++) {
            for(int j = 1; j <= pLen; j++) {
                if(pCharArray[j-1] == '*') {
                    dp[i][j] = dp[i][j-2];
                    if(matchs(sCharArray, pCharArray, i, j -1)) {
                        dp[i][j] |= dp[i-1][j];
                    }
                }

                else if(matchs(sCharArray, pCharArray, i, j)) dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[sLen][pLen];
    }
    private boolean matchs(char[] s, char[] p, int i, int j) {
        if(i == 0) return false;
        if(p[j-1] == '.') return true;
        return s[i-1] == p[j-1];
    }
}
