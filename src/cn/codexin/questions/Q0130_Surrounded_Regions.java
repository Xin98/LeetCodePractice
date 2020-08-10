package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/11
 */

public class Q0130_Surrounded_Regions {
    private int[] parent;

    public int unionSearch(int root) {
        if(parent[root] != root) {
            parent[root] = unionSearch(parent[root]);
        }
        return parent[root];
    }
    public void join(int x, int y) {
        int rootX = unionSearch(x);
        int rootY = unionSearch(y);
        if(rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) {
            return;
        }
        int n = board[0].length;
        // 初始化parent， 边界的parent为-1
        parent = new int[m * n + 1];
        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
        }
        int dummyNode = m * n;
        // 并查集
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i * n + j;
                if(board[i][j] == 'O') {
                    if(i + 1 < m && board[i + 1][j] == 'O'){
                        int y = (i + 1) * n + j;
                        join(x, y);
                    }
                    if(j + 1 < n && board[i][j + 1] == 'O') {
                        int y = i * n + j + 1;
                        join(x, y);
                    }
                    if(i == 0 || j == 0 || i == m-1 || j == n-1) {
                        join(x, dummyNode);
                    }
                }
            }
        }
        // 翻转符合条件的O , 外围不用考虑
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if(board[i][j] == 'O' && unionSearch(i*n + j) != unionSearch(dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
