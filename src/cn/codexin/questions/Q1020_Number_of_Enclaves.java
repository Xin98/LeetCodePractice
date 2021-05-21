package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/21
 */

public class Q1020_Number_of_Enclaves {
    private int m;
    private int n;
    private int[][] A;
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numEnclaves(int[][] A) {
        this.A = A;
        this.m = A.length;
        this.n = A[0].length;
        for (int i = 0; i < m; i++) {
            if(A[i][0] == 1) {
                dfs(i, 0);
            }
            if(A[i][n - 1] == 1) {
                dfs(i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if(A[0][i] == 1) {
                dfs(0, i);
            }
            if(A[m - 1][i] == 1) {
                dfs(m - 1, i);
            }
        }
        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if(A[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni < 0 || nj < 0 || ni == m || nj == n || A[ni][nj] == 0) {
                continue;
            }
            A[ni][nj] = 0;
            dfs(ni, nj);
        }
    }

}
