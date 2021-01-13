package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/13
 */

public class Q0684_Redundant_Connection {
    class UnionFind{
        private int[] f;
        public UnionFind(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        public int search(int x) {
            if(x != f[x]) {
                f[x] = search((f[x]));
            }
            return f[x];
        }

        public void merge(int x, int y) {
            int fx = search(x);
            int fy = search(y);
            if(fx != fy) {
                f[fx] = fy;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for (int[] edge : edges) {
            if(uf.search(edge[0]) != uf.search(edge[1])) {
                uf.merge(edge[0], edge[1]);
            } else {
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[]{};
    }
}
