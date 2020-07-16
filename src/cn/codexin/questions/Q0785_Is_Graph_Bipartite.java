package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/16
 */

public class Q0785_Is_Graph_Bipartite {
    private static final int UNMARK = 0;
    private static final int RED = 1;
    private static final int BLUE = 2;
    private int[] color;
    private boolean valid;


    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        valid = true;
        for (int i = 0; i < n && valid; i++) {
            if(color[i] == UNMARK) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }
    public void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int cNei = c == RED? BLUE : RED;
        for (int neighbor : graph[node]) {
            if(color[neighbor] == UNMARK) {
                dfs(neighbor, cNei, graph);
                if(!valid) {
                    return;
                }
            } else if(color[neighbor] != cNei) {
                valid = false;
                return;
            }
        }
    }
}
