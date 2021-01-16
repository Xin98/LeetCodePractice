package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/1/16
 */

public class Q0803_Bricks_Falling_When_Hit {
    private int m;
    private int n;

    class UnionFind {
        private int[] f;
        private int[] size;

        public UnionFind(int n) {
            f = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int search(int x) {
            if (x != f[x]) {
                f[x] = search((f[x]));
            }
            return f[x];
        }

        public void merge(int x, int y) {
            int fx = search(x);
            int fy = search(y);
            if (fx != fy) {
                f[fx] = fy;
                size[fy] += size[fx];
            }
        }

        public int getSize(int x) {
            return size[search(x)];
        }
    }

    private int getIndex(int x, int y) {
        return x * n + y;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.m = grid.length;
        this.n = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int size = m * n;
        UnionFind uf = new UnionFind(size + 1);
        int[][] cp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cp[i][j] = grid[i][j];
            }
        }
        //1. remove all hit bricks
        for (int[] hit : hits) {
            int i = hit[0];
            int j = hit[1];
            cp[i][j] = 0;
        }

        //2. merge all top-connected bricks
        for (int j = 0; j < n; j++) {
            if (cp[0][j] == 1) {
                uf.merge(j, size);
            }
        }
        //3. merge all connected bricks
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cp[i][j] != 1) {
                    continue;
                }
                if (j > 0 && cp[i][j - 1] == 1) {
                    uf.merge(getIndex(i, j), getIndex(i, j - 1));
                }
                if (cp[i - 1][j] == 1) {
                    uf.merge(getIndex(i, j), getIndex(i - 1, j));
                }
            }
        }
        //4. restore bricks by reverse hit order
        int hitLen = hits.length;
        int[] res = new int[hitLen];
        for (int i = hitLen - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            // empty hit will change nothing.
            if (grid[x][y] == 0) {
                continue;
            }
            int origin = uf.getSize(size);
            if (x == 0) {
                uf.merge(y, size);
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (inArea(nx, ny) && cp[nx][ny] == 1) {
                    uf.merge(getIndex(x, y), getIndex(nx, ny));
                }
            }
            int current = uf.getSize(size);
            res[i] = Math.max(0, current - origin - 1);
            cp[x][y] = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Q0803_Bricks_Falling_When_Hit Q = new Q0803_Bricks_Falling_When_Hit();
        Q.hitBricks(new int[][]{{1, 0, 1}, {1, 1, 1}}, new int[][]{{0, 0}, {0, 2}, {1, 1}});
    }
}
