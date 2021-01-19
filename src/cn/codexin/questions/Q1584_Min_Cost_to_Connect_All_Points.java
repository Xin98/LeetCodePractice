package cn.codexin.questions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/1/19
 */

public class Q1584_Min_Cost_to_Connect_All_Points {
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

    class Edge {
        private int len;
        private int x;
        private int y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }

    public int distance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(distance(points[i], points[j]), i, j));
            }
        }
        UnionFind uf = new UnionFind(n);
        Collections.sort(edges, (e1, e2)-> e1.len - e2.len);
        int cnt = 1, ans = 0;
        for (Edge edge : edges) {
            if(!uf.merge(edge.x, edge.y)) {
                continue;
            }
            cnt++;
            ans += edge.len;
            if(cnt == n) {
                break;
            }
        }
        return ans;
    }


}
