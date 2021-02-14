package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/2/14
 */

public class Q0765_Couples_Holding_Hands {
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

    }
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        UnionFind uf = new UnionFind(n / 2);
        for (int i = 0; i < n; i += 2) {
            uf.merge(row[i] / 2, row[i + 1] / 2);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n / 2; i++) {
            int pi = uf.search(i);
            map.put(pi, map.getOrDefault(pi, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += entry.getValue() - 1;
        }
        return ans;
    }
}
