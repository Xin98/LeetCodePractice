package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/13
 */

public class Q0079_Word_Search {
    private int[] dx = new int[] {1, -1, 0, 0};
    private int[] dy = new int[] {0, 0, 1, -1};
    private boolean isFind;
    private char[][] board;
    private String word;
    private boolean[][] used;
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.isFind = false;
        this.m = board.length;
        this.n = board[0].length;
        this.used = new boolean[m][n];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(sb, i, j);
            }
        }
        return isFind;
    }
    public void dfs(StringBuilder sb, int x, int y) {
        if(isFind || used[x][y] || sb.length() == word.length()) {
            return;
        }
        String tmp = sb.toString();
        if(!tmp.equals(word.substring(0, tmp.length()))) {
            return;
        }
        sb.append(board[x][y]);
        used[x][y] = true;
        if(sb.toString().equals(word)) {
            isFind = true;
            return;
        }
        for(int i = 0; i < 4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];
            if(xn < 0 || xn >= m || yn < 0 || yn >= n) {
                continue;
            }
            dfs(sb, xn, yn);
        }
        used[x][y] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
