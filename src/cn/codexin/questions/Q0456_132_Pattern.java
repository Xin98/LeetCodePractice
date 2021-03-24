package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/3/24
 */

public class Q0456_132_Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[n - 1]);
        int maxValue2 = Integer.MIN_VALUE;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < maxValue2) {
                return true;
            }
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                maxValue2 = stack.pop();
            }
            if(nums[i] > maxValue2) {
                stack.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q0456_132_Pattern Q = new Q0456_132_Pattern();
        Q.find132pattern(new int[]{3,5,0,3,4});
    }
}
