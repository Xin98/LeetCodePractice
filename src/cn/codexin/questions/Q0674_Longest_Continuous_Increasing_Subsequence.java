package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/24
 */

public class Q0674_Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int ans = 1;
        int cnt = 1;
        int last = nums[0];
        for (int num : nums) {
            if(num > last) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
            last = num;
        }
        return Math.max(ans, cnt);
    }
}
