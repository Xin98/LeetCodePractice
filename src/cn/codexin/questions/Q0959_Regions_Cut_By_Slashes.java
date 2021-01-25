package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/25
 */

public class Q0959_Regions_Cut_By_Slashes {
    class UnionFind {
        private int[] f;
        private int setCount;
        public UnionFind(int n) {
            f = new int[n];
            setCount = n;
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
                setCount--;
                return true;
            }
            return false;
        }

        public int getSetCount() {
            return setCount;
        }
    }
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < n; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = row[j];
                // merge sub-grid in one grid
                if(c == '/') {
                    uf.merge(index, index + 3);
                    uf.merge(index + 1, index + 2);

                } else if(c == '\\') {
                    uf.merge(index, index + 1);
                    uf.merge(index + 2, index + 3);
                } else {
                    uf.merge(index, index + 1);
                    uf.merge(index + 1, index + 2);
                    uf.merge(index + 2, index + 3);
                }
                // merge  sub-grid in different grid
                if(j + 1 < n) {
                    uf.merge(index + 1, index + 7);
                }
                if(i + 1 < n) {
                    uf.merge(index + 2, index + 4 * n);
                }
            }
        }
        return uf.getSetCount();
    }
}
