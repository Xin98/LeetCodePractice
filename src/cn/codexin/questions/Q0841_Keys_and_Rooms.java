package cn.codexin.questions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xinGao 2020/8/31
 */

public class Q0841_Keys_and_Rooms {
    private boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);
        for (boolean flag : visited) {
            if(flag == false) {
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> graph, int i) {
        if(visited[i] == true) {
            return;
        }
        visited[i] = true;
        for (Integer node : graph.get(i)) {
            dfs(graph, node);
        }
    }
}
