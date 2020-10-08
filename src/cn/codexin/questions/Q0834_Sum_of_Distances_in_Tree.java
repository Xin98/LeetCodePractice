package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/10/8
 */

public class Q0834_Sum_of_Distances_in_Tree {
    private int[] ans;
    private int[] dp;
    private int[] sz;
    private List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        graph = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new LinkedList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dp = new int[N];
        sz = new int[N];
        ans = new int[N];
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int u, int p) {
        dp[u] = 0;
        sz[u] = 1;
        for(int v : graph.get(u)) {
            if(v == p) {
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    public void dfs2(int u, int p) {
        ans[u] = dp[u];
        for(int v : graph.get(u)) {
            if(v == p) {
                continue;
            }
            int pu = dp[u], su = sz[u];
            int pv = dp[v], sv = sz[v];
            dp[u] -= (dp[v] + sz[v]);
            sz[u] -= sz[v];
            dp[v] += (dp[u] + sz[u]);
            sz[v] += sz[u];
            dfs2(v, u);
            dp[u] = pu;
            sz[u] = su;
            dp[v] = pv;
            sz[v] = sv;
        }
    }
}
