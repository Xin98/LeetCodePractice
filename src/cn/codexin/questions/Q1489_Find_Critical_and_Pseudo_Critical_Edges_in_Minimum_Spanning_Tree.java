package cn.codexin.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/1/21
 */

public class Q1489_Find_Critical_and_Pseudo_Critical_Edges_in_Minimum_Spanning_Tree {
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
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            // save previous index
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);
        // compute mst's value
        int value = 0;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            if(uf.merge(newEdges[i][0], newEdges [i][1])) {
                value += newEdges[i][2];
            }
        }

        List<List<Integer>> ans = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            ans.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            uf = new UnionFind(n);
            int v = 0;
            for (int j = 0; j < m; j++) {
                if(j != i && uf.merge(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            // critical edges
            if(uf.getSetCount() != 1 || (uf.getSetCount() == 1 && v > value)) {
                ans.get(0).add(newEdges[i][3]);
                continue;
            }
            // pseudo critical edges
            uf = new UnionFind(n);
            uf.merge(newEdges[i][0], newEdges[i][1]);
            v = newEdges[i][2];
            for (int j = 0; j < m; j++) {
                if(j != i && uf.merge(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if(v == value) {
                ans.get(1).add(newEdges[i][3]);
            }
        }
        return ans;
    }
}
