package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/17
 */

public class Q0052_N_Queens_II {
    private boolean[] col;
    private boolean[] diag1;
    private boolean[] diag2;
    private int ans;
    public int totalNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        ans = 0;
        dfs(n, 0);
        return ans;
    }
    public void dfs(int n, int row) {
        if(row == n) {
            ans++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(col[i] || diag1[n - 1 - row + i] || diag2[row + i]) {
                continue;
            }
            col[i] = true;
            diag1[n - 1 - row + i] = true;
            diag2[row + i] = true;
            dfs(n, row + 1);
            col[i] = false;
            diag1[n - 1 - row + i] = false;
            diag2[row + i] = false;
        }
    }
}
