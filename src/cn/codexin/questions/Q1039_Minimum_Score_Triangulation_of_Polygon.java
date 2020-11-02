package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/2
 */

public class Q1039_Minimum_Score_Triangulation_of_Polygon {
    public int minScoreTriangulation(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        for(int i = len - 3; i >= 0; i--) {
            for(int j = i + 2; j < len; j++) {
                for(int m = i + 1; m < j; m++) {
                    if(dp[i][j] == 0) {
                        dp[i][j] = dp[i][m] + dp[m][j] + A[i] * A[j] * A[m];
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m][j] + A[i] * A[j] * A[m]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
