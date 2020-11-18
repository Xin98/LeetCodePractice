package cn.codexin.questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xinGao 2020/11/18
 */

public class Q0862_Shortest_Subarray_with_Sum_at_Least_K {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        long[] pre = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            pre[i] += pre[i - 1] + A[i - 1];
        }
        int ans = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int y = 0; y <= n; y++) {
            while(!queue.isEmpty() && pre[y] <= pre[queue.getLast()]) {
                queue.removeLast();
            }
            while(!queue.isEmpty() && pre[y] >= pre[queue.getFirst()] + K) {
                ans = Math.min(ans, y - queue.getFirst());
                queue.removeFirst();
            }
            queue.addLast(y);
        }
        return ans == n + 1 ? - 1 : ans;
    }
}
