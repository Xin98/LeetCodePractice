package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/12
 */

public class Q0174_Dungeon_Game {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        //处于m, n位置 至少要保持的血量
        int[][] dp = new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1) {
                    dp[i][j] = dungeon[i][j] > 0 ? 1 : (1 - dungeon[i][j]);
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                if(i != m - 1) {
                    // dp任何位置的血量都不能少于1
                    dp[i][j] = Math.min(dp[i][j], Math.max(1, dp[i+1][j] - dungeon[i][j]));
                }
                if(j != n - 1) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(1, dp[i][j+1] - dungeon[i][j]));
                }
            }
        }
        return dp[0][0];
    }
}
