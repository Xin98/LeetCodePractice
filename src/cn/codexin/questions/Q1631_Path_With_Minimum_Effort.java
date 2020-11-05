package cn.codexin.questions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xinGao 2020/11/5
 */

public class Q1631_Path_With_Minimum_Effort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[] seen = new boolean[m * n];
        int[] dist = new int[m * n];
        Queue<int[]> q = new PriorityQueue<>((x, y)->x[2] - y[2]);
        q.offer(new int[]{0, 0, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], z = cur[2];
            if(seen[x * n + y]) {
                continue;
            }
            dist[x * n + y] = z;
            seen[x * n + y] = true;
            for(int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if(nx < 0 || ny < 0 ||  nx >= m || ny >= n || seen[nx * n + ny]) {
                    continue;
                }
                q.offer(new int[] {nx, ny, Math.max(z, Math.abs(heights[x][y] - heights[nx][ny]))});
            }
        }
        return dist[m * n - 1];
    }
}
