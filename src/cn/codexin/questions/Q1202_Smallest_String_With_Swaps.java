package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/1/11
 */

public class Q1202_Smallest_String_With_Swaps {
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
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            uf.merge(pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int fi = uf.search(i);
            if(!map.containsKey(fi)) {
                map.put(fi, new PriorityQueue<>());
            }
            map.get(fi).offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(uf.search(i)).poll());
        }
        return sb.toString();
    }
}
