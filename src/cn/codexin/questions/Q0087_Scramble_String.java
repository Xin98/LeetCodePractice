package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/16
 */

public class Q0087_Scramble_String {
    private int[][][] memo;
    private String s1;
    private String s2;

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        memo = new int[len][len][len + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, len);
    }
    private boolean dfs(int i, int j, int len) {
        if(memo[i][j][len] != 0) {
            return memo[i][j][len] == 1;
        }
        if(s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            memo[i][j][len] = 1;
            return true;
        }
        if(!checkSimilar(i, j, len)) {
            memo[i][j][len] = -1;
            return false;
        }
        for (int k = 1; k < len; k++) {
            if(dfs(i, j, k) && dfs(i + k, j + k, len - k)) {
                memo[i][j][len] = 1;
                return true;
            }
            if(dfs(i + len - k, j, k) && dfs(i, j + k, len - k)) {
                memo[i][j][len] = 1;
                return true;
            }
        }
        memo[i][j][len] = -1;
        return false;
    }

    private boolean checkSimilar(int i, int j, int len) {
        int[] freq = new int[26];
        for(int k = i; k < i + len; k++) {
            freq[s1.charAt(k) - 'a']++;
        }
        for(int k = j; k < j + len; k++) {
            if(--freq[s2.charAt(k) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
