package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/10/16
 */

public class Q0373_Find_K_Pairs_with_Smallest_Sums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> ans = new LinkedList<>();
        if(m == 0 || n == 0) {
            return ans;
        }
        queue.offer(new int[] {0, 0});
        while(ans.size() < k && !queue.isEmpty()) {
            int[] pair = queue.poll();
            ans.add(new ArrayList<>(Arrays.asList(nums1[pair[0]], nums2[pair[1]])));
            if(pair[0] + 1 < m) {
                queue.offer(new int[] {pair[0] + 1, pair[1]});
            }
            if(pair[0] == 0 && pair[1] + 1 < n) {
                queue.offer(new int[] {pair[0], pair[1] + 1});
            }
        }
        return ans;
    }
}
