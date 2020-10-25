package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/25
 */

public class Q0845_Longest_Mountain_in_Array {
    public int longestMountain(int[] A) {
        int n = A.length;
        if(n < 3) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        int ans = 0;
        for(int i = 1; i < n; i++) {
            if(A[i] > A[i-1]) {
                dp[i][0] = dp[i-1][0] + 1;
            } else if(A[i] < A[i-1]) {
                dp[i][0] = 1;
                if(dp[i-1][1] > 0) {
                    dp[i][1] = dp[i-1][1] + 1;
                } else if(dp[i-1][0] > 1) {
                    dp[i][1] = dp[i-1][0] + 1;
                }
                ans = Math.max(ans, dp[i][1]);
            } else {
                dp[i][0] = 1;
            }
        }
        return ans;
    }
}
