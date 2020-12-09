package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/12/9
 */

public class Q0417_Pacific_Atlantic_Water_Flow {

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int n;
    private int m;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new LinkedList<>();
        n = matrix.length;
        if(n == 0) {
            return ans;
        }
        m = matrix[0].length;
        if(m == 0) {
            return ans;
        }
        int[][] po = new int[n][m];
        int[][] ao = new int[n][m];
        for(int i = 0; i < n; i++) {
            dfs(matrix, i, 0, po);
            dfs(matrix, i, m - 1, ao);
        }
        for(int i = 0; i < m; i++) {
            dfs(matrix, 0, i, po);
            dfs(matrix, n - 1, i, ao);
        }
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(po[i][j] == 1 && ao[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] matrix, int x, int y, int[][] ocean) {
        ocean[x][y] = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if(nx < 0 || nx == n || ny < 0 || ny == m || matrix[nx][ny] < matrix[x][y] || ocean[nx][ny] == 1) {
                continue;
            }
            dfs(matrix, nx, ny, ocean);
        }
    }

    public static void main(String[] args) {
        Q0417_Pacific_Atlantic_Water_Flow Q = new Q0417_Pacific_Atlantic_Water_Flow();
        Q.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
    }
}
