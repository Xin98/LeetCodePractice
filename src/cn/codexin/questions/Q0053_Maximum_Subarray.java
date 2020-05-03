package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/3
 */

public class Q0053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int acc = 0, ans = Integer.MIN_VALUE;
        for (int num : nums) {
            acc += num;
            ans = Math.max(ans, acc);
            if(acc < 0) acc = 0;
        }
        return ans;
    }
}
