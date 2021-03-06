package cn.codexin.questions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/3/6
 */

public class Q0503_Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        if(n == 0) {
            return ans;
        }
        stack.push(0);
        for(int i = 1; i < 2 * n - 1; i++) {
            if(i >= n && stack.isEmpty()) {
                break;
            }
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }
            if(i < n) {
                stack.push(i);
            }
        }
        return ans;
    }
}
