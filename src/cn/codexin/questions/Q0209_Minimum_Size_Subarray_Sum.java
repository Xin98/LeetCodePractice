package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/28
 */

public class Q0209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int begin = 0;
        int end = 0;
        int sum = 0;
        int ans = n + 1;
        while(end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - begin + 1);
                sum -= nums[begin++];
            }
            end++;
        }
        return ans == n + 1 ? 0 : ans;
    }

}
