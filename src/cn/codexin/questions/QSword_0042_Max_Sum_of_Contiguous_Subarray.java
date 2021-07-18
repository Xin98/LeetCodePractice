package cn.codexin.questions;

/**
 * Created by xinGao 2021/7/17
 */

public class QSword_0042_Max_Sum_of_Contiguous_Subarray {
    public int maxSubArray(int[] nums) {
        int sum = 0, ans = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}
