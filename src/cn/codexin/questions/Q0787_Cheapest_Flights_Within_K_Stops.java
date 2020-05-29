package cn.codexin.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinGao 2020/5/29
 */

public class Q0787_Cheapest_Flights_Within_K_Stops {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        Queue<int[]> queue = new LinkedList<>();
        // 开始 起点为src ， 花费为0
        queue.offer(new int[]{src, 0});
        int ans = Integer.MAX_VALUE;
        while(K >= 0 && !queue.isEmpty()) {
            K--;
            int size = queue.size();
            while(size > 0) {
                size--;
                int[] info = queue.poll();
                for(int i = 0; i < n; i++) {
                    if(graph[info[0]][i] == 0) continue;
                    int newCost = info[1] + graph[info[0]][i];
                    if(newCost > ans) continue;
                    int[] newInfo = {i, newCost};
                    if(i == dst) {
                        ans = Math.min(ans, newCost);
                    } else {
                        queue.offer(newInfo);
                    }
                }

            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

}
