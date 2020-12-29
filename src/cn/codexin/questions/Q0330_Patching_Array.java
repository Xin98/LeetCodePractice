package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/29
 */

public class Q0330_Patching_Array {
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int ans = 0;
        int idx = 0;
        int len = nums.length;
        while(x <= n) {
            if(idx < len && nums[idx] <= x) {
                x += nums[idx];
                idx++;
            } else {
                ans++;
                x *= 2;
            }
        }
        return ans;
    }
}
