package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/27
 */

public class Q1579_Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable {
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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufa = new UnionFind(n + 1);
        UnionFind ufb = new UnionFind(n + 1);
        int ans = 0;
        for (int[] edge : edges) {
            // common edge merge
            if(edge[0] == 3) {
                if(!ufa.merge(edge[1], edge[2])) {
                    ans++;
                } else {
                    ufb.merge(edge[1], edge[2]);
                }
            }
        }
        // private edge merge
        for (int[] edge : edges) {
            if(edge[0] == 1 && !ufa.merge(edge[1], edge[2])) {
                ans++;
            }
            if(edge[0] == 2 && !ufb.merge(edge[1], edge[2])) {
                ans++;
            }
        }
        return ufa.setCount == 2 && ufb.setCount == 2 ? ans : -1;
    }
}
