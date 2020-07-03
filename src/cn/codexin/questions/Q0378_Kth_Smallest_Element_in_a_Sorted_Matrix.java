package cn.codexin.questions;

import java.util.PriorityQueue;

/**
 * Created by xinGao 2020/7/2
 */

public class Q0378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] arr = new int[k];
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y)->x[0] - y[0]);
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = queue.poll();
            if(now[2] != n - 1) {
                queue.offer(new int[]{matrix[now[1]][now[2]+1], now[1], now[2] + 1});
            }
        }
        return queue.poll()[0];
    }
}
