package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/6
 */

public class Q0474_Ones_and_Zeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            int[] zerosOnes = getZerosOnes(strs[i]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getZerosOnes(String str) {
        int[] ans = new int[2];
        for (char c : str.toCharArray()) {
            ans[c - '0']++;
        }
        return ans;
    }
}
