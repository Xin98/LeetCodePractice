package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/1/2
 */

public class Q0239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[dq.peekFirst()];
        for(int i = k; i < n; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
            while(dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            ans[i - k + 1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
