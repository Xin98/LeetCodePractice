package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/9/25
 */

public class Q0481_Magical_String {
    public int magicalString(int n) {
        if(n == 0) {
            return 0;
        }
        if(n < 3) {
            return 1;
        }
        int[] nums = new int[n];
        int cnt = 1;
        nums[0] = 1;
        nums[1] = nums[2] = 2;
        int last = 2;
        int fast = 3, slow = 2;
        for(;fast < n;) {
            int times = nums[slow++];
            if(fast + times >= n) {
                times = n - fast;
            }
            Arrays.fill(nums, fast, fast + times, last == 1 ? 2 : 1);
            fast += times;
            last = last == 1 ? 2 : 1;
            if(last == 1) {
                cnt += times;
            }
        }
        return cnt;
    }
}
