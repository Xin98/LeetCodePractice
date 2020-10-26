package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/26
 */

public class Q1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        int[] cnt = new int[101];
        int[] ans = new int[nums.length];
        for(int num : nums) {
            freq[num]++;
        }
        for(int i = 1; i <= 100; i++) {
            cnt[i] = cnt[i-1] + freq[i-1];
        }
        for(int i = 0; i < nums.length; i++) {
            ans[i] = cnt[nums[i]];
        }
        return ans;
    }
}
