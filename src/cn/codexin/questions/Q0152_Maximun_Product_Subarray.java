package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/18
 */

public class Q0152_Maximun_Product_Subarray {
    public int maxProduct(int[] nums) {
        int minF = 1, maxF = 1, ans = nums[0];
        for (int num : nums) {
            int mn = minF, mx = maxF;
            if(num >= 0) {
                maxF = Math.max(num, mx * num);
                minF = Math.min(num, mn * num);
            } else {
                maxF = Math.max(num, mn * num);
                minF = Math.min(num, mx * num);
            }
            ans = Math.max(ans, maxF);
        }
        return ans;
    }
}
