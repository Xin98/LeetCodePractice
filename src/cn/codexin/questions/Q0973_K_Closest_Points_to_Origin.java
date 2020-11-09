package cn.codexin.questions;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xinGao 2020/11/9
 */

public class Q0973_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> queue = new PriorityQueue<>((a, b)->b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for(int[] point : points) {
            queue.offer(point);
            if(queue.size() > K) {
                queue.poll();
            }
        }
        int[][] ans = new int[K][2];
        for(int i = 0; i < K; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
