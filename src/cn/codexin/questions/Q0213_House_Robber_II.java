package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/15
 */

public class Q0213_House_Robber_II {
    public int rob(int[] nums) {
        return Math.max(nums[0] + rob(nums, 2, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    public int rob(int[] nums, int begin, int end) {
        if(begin > end) {
            return 0;
        }
        int a = 0, b = 0, ans = 0;
        for(int i = begin; i <= end; i++) {
            ans = Math.max(a + nums[i], b);
            a= b;
            b = ans;
        }
        return ans;
    }
}
