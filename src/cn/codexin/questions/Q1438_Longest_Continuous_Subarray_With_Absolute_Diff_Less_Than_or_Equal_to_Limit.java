package cn.codexin.questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xinGao 2021/2/21
 */

public class Q1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQue = new ArrayDeque<>();
        Deque<Integer> minQue = new ArrayDeque<>();
        int left = 0, right = 0;
        int ans = 0;
        int n = nums.length;
        while(right < n) {
            while (!maxQue.isEmpty() && maxQue.peekLast() < nums[right]) {
                maxQue.pollLast();
            }
            while (!minQue.isEmpty() && minQue.peekLast() > nums[right]) {
                minQue.pollLast();
            }
            maxQue.offerLast(nums[right]);
            minQue.offerLast(nums[right]);
            while (!maxQue.isEmpty() && !minQue.isEmpty() && maxQue.peekFirst() - minQue.peekFirst() > limit) {
                if(nums[left] == minQue.peekFirst()) {
                    minQue.pollFirst();
                }
                if(nums[left] == maxQue.peekFirst()) {
                    maxQue.pollFirst();
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
