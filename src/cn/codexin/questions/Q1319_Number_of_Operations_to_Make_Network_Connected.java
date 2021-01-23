package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/23
 */

public class Q1319_Number_of_Operations_to_Make_Network_Connected {
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
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            uf.merge(connection[0], connection[1]);
        }
        return uf.getSetCount() - 1;
    }
}
