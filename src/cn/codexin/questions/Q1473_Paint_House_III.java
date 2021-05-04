package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/5/4
 */

public class Q1473_Paint_House_III {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target];
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < m; i++) {
            houses[i]--;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(houses[i] != -1 && houses[i] != j) {
                    continue;
                }
                for (int k = 0; k < target; k++) {
                    for (int j0 = 0; j0 < n; j0++) {
                        if(j == j0) {
                            if(i == 0) {
                                if(k == 0) {
                                    dp[i][j][k] = 0;
                                }
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                            }
                        } else if(i > 0 && k > 0) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
                        }

                    }
                    if(dp[i][j][k] != INF && houses[i] == -1) {
                        dp[i][j][k] += cost[i][j];
                    }

                }
            }
        }
        int ans = INF;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m - 1][i][target - 1]);
        }
        return ans == INF ? - 1: ans;
    }
}
