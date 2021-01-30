package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/30
 */

public class Q0778_Swim_in_Rising_Water {
    class UnionFind {
        private int[] f;
        public UnionFind(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        public int search(int x) {
            return x == f[x] ? x : (f[x] = search(f[x]));
        }

        public boolean merge(int x, int y) {
            int fx = search(x);
            int fy = search(y);
            if (fx != fy) {
                f[fx] = fy;
                return true;
            }
            return false;
        }

        public boolean connected(int x, int y) {
            return search(x) == search(y);
        }
    }
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int idx[][] = new int[N * N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                idx[grid[i][j]][0] = i;
                idx[grid[i][j]][1] = j;
            }
        }
        UnionFind uf = new UnionFind(N * N);
        for (int threshold = 0; threshold < N * N; threshold++) {
            int x = idx[threshold][0];
            int y = idx[threshold][1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] <= threshold) {
                    uf.merge(x * N + y, nx * N + ny);
                }
            }
            if(uf.connected(0, N * N - 1)) {
                return threshold;
            }
        }
        return -1;
    }
}
