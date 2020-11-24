package cn.codexin.questions;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xinGao 2020/11/24
 */

public class Q0407_Trapping_Rain_Water_II {
    class Cell implements Comparable<Cell> {
        private int row;
        private int col;
        private int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
        @Override
        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = heightMap.length;
        int n = heightMap[0].length;
        if(m <= 2 || n <= 2) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n- 1]));
        }
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        int ans = 0;
        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                ans += Math.max(0, cell.height - heightMap[row][col]);
                queue.offer(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
            }
        }
        return ans;
    }
}
