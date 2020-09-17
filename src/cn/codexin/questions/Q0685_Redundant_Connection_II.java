package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/17
 */

public class Q0685_Redundant_Connection_II {
    class UnionSearch{
        private int[] parent;
        public UnionSearch(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int search(int n) {
            if(parent[n] != n) {
                parent[n] = search(parent[n]);
            }
            return parent[n];
        }
        public void union(int x, int y) {
            int px = search(x);
            int py = search(y);
            if(px != py) {
                parent[y] = px;
            }
        }
    }


    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionSearch us = new UnionSearch(n + 1);
        int conflact = -1;
        int circle = -1;
        int[] parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            if(parent[node2] != node2) {
                conflact = i;
            } else {
                parent[node2] = node1;
                if(us.search(node1) == us.search(node2)) {
                    circle = i;
                } else {
                    us.union(node1, node2);
                }
            }
        }
        if(conflact < 0) {
            return edges[circle];
        } else {
            if(circle >= 0) {
                return new int[] {parent[edges[conflact][1]], edges[conflact][1]};
            } else {
                return edges[conflact];
            }
        }
    }
}
