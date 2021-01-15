package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/15
 */

public class Q0947_Most_Stones_Removed_with_Same_Row_or_Column {
    class UnionFind{
        private int[] f;
        private int cnt;
        public UnionFind(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
            cnt = 0;
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
                cnt++;
            }
        }

        public int getCnt() {
            return cnt;
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.merge(i, j);
                }
            }
        }
        return uf.getCnt();
    }
}
