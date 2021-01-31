package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/31
 */

public class Q0839_Similar_String_Groups {
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
    public boolean check(String a, String b) {
        int len = a.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        if(cnt > 2) {
            return false;
        }
        return true;
    }
    public int numSimilarGroups(String[] strs) {
        int N = strs.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(check(strs[i], strs[j])) {
                    uf.merge(i, j);
                }
            }
        }
        return uf.getSetCount();
    }
}
