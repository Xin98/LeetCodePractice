package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2020/8/4
 */

public class Q0207_Course_Schedule {
    private List<List<Integer>> edges;
    private int[] visited;
    private boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (Integer v : edges.get(u)) {
            if(visited[v] == 0) {
                dfs(v);
                if(!valid) {
                    return;
                }
            } else if(visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
