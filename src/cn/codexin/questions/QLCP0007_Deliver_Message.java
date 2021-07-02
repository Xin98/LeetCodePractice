package cn.codexin.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinGao 2021/7/1
 */

public class QLCP0007_Deliver_Message {
    public int numWays(int n, int[][] relation, int k) {
        boolean[][] edges = new boolean[n][n];
        for (int[] edge : relation) {
            edges[edge[0]][edge[1]] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ans = 0;
        for(int i = 0; !queue.isEmpty(); i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int pos = queue.poll();
                if(i == k) {
                    if(pos == n - 1) {
                        ans++;
                    }
                    continue;
                }
                for (int nextPos = 0; nextPos < n; nextPos++) {
                    if(edges[pos][nextPos]) {
                        queue.offer(nextPos);
                    }
                }
            }
        }
        return ans;
    }
}
