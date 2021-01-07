package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/7
 */

public class Q0547_Number_of_Provinces {
    class UnionFind{
        private int[] f;
        private int cnt;
        public UnionFind(int n) {
            cnt = n;
            f = new int[n];
            for(int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        public int find(int x) {
            if(x != f[x]) {
                f[x] = find(f[x]);
            }
            return f[x];
        }

        public void merge(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if(fx != fy) {
                cnt--;
                f[fx] = fy;
            }
        }

        public int getAnswer() {
            return this.cnt;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(isConnected[i][j] == 1) {
                    uf.merge(i, j);
                }
            }
        }
        return uf.getAnswer();
    }
}
