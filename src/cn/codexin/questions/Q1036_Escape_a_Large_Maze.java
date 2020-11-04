package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/11/4
 */

public class Q1036_Escape_a_Large_Maze {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked.length == 0) {
            return true;
        }
        Set<String> blockedSet = new HashSet<>();
        for(int[] pos : blocked) {
            blockedSet.add(pos[0] + "," + pos[1]);
        }
        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    public boolean bfs(int[] start, int[] end, Set<String> blocked) {
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start[0] + "," + start[1]);
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(Arrays.equals(cur, end)){
                return true;
            }
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= 1e6 || ny >= 1e6) {
                    continue;
                }
                String s = nx + "," + ny;
                if(visited.contains(s) || blocked.contains(s)) {
                    continue;
                }
                visited.add(s);
                queue.offer(new int[]{nx, ny});
            }
            if(visited.size() > 20000) {
                return true;
            }
        }
        return false;
    }
}
