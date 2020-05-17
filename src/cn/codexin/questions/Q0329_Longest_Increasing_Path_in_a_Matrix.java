package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/5/17
 */

public class Q0329_Longest_Increasing_Path_in_a_Matrix {
    //dfs+记忆化搜索
    private int[][] memo;
    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};
    private int n, m;
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        if (n == 0) return 0;
        m = matrix[0].length;
        memo = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j, matrix));
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] matrix) {
        if (memo[x][y] != 0) return memo[x][y];
        int len = 1;
        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            if(newx < 0 || newy < 0 || newx >= n || newy >= m || matrix[newx][newy] <= matrix[x][y]) continue;
            len = Math.max(len, 1 + dfs(newx, newy, matrix));
        }
        memo[x][y] = len;
        return len;
    }
}
