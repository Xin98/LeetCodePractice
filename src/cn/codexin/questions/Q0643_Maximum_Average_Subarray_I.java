package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/15
 */

public class Q0643_Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        int acc = 0;
        for (int i = 0; i < k; i++) {
            acc += nums[i];
        }
        int ans = acc;
        for (int i = k; i < nums.length; i++) {
            acc += nums[i] - nums[i-k];
            ans = Math.max(ans, acc);
        }
        return (double) ans / k;
    }
}
