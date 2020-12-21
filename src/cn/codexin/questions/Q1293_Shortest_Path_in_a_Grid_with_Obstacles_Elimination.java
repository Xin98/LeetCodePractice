package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinGao 2020/12/21
 */

public class Q1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination {
    //bfs
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) {
            return 0;
        }
        k = Math.min(k, m + n - 3);
        boolean[][][] visited = new boolean[m][n][k + 1];
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            ans++;
            for (int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if(nx == m - 1 && ny == n - 1) {
                        return ans;
                    }
                    int nk = cur[2] - (grid[nx][ny] == 1 ? 1 : 0);
                    if(nk < 0 || visited[nx][ny][nk]) {
                        continue;
                    }
                    queue.offer(new int[]{nx, ny, nk});
                    visited[nx][ny][nk] = true;
                }
            }

        }
        return -1;
    }


    //dfs 超时
//    private boolean[][] visited;
//    private int m;
//    private int n;
//    // k 和 (40 - depth） 保存到一个int中 低6位保存depth， 其余的保存k
//    private int[][] memo;
//    private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//    private int ans = Integer.MAX_VALUE;
//    public int shortestPath(int[][] grid, int k) {
//        m = grid.length;
//        n = grid[0].length;
//        memo = new int[m][n];
//        visited = new boolean[m][n];
//        dfs(grid, 0, 0, k, 0);
//        return ans == Integer.MAX_VALUE ? -1 : ans;
//    }
//
//    public boolean worseSearch(int k, int depth, int former) {
//        return depth > (m + n - 2) || ((former >> 6) > k && (former & (1 << 6 - 1)) > (40 - depth));
//    }
//    public boolean betterSearch(int k, int depth, int former) {
//        return (former >> 6) <= k && (former & (1 << 6 - 1)) <= (40 - depth);
//    }
//
//    public void dfs(int[][] grid, int x, int y, int k, int depth) {
//        if(visited[x][y] || worseSearch(k, depth, memo[x][y]) || (k == 0 && grid[x][y] == 1)) {
//            return;
//        }
//        if(x == m - 1 && y == n -1) {
//            ans = Math.min(ans, depth);
//            return;
//        }
//        if(betterSearch(k, depth, memo[x][y])) {
//            memo[x][y] = k << 6 + (40 - depth);
//        }
//        visited[x][y] = true;
//        if(grid[x][y] == 1) {
//            k--;
//        }
//        for (int[] dir : dirs) {
//            int nx = x + dir[0];
//            int ny = y + dir[1];
//            if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
//                continue;
//            }
//            dfs(grid, nx, ny, k, depth + 1);
//        }
//        visited[x][y] = false;
//    }

    public static void main(String[] args) {
        Q1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination Q = new Q1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination();
        Q.shortestPath(new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}}, 1);
    }
}
