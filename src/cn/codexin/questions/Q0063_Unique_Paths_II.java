package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/6
 */

public class Q0063_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if(n == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else{
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if(obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else{
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
