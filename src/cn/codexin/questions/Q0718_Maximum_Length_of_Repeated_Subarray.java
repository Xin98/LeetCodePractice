package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/1
 */

public class Q0718_Maximum_Length_of_Repeated_Subarray {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
