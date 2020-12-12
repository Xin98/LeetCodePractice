package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/12
 */

public class Q0376_Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        //0 1 -1 1 1 1 -1 -1 1 -1
        int n = nums.length;
        if(n < 2) {
            return n;
        }
        int preDiff = nums[1] - nums[0];
        int ans = preDiff == 0 ? 1 : 2;
        for(int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if(diff > 0 && preDiff <= 0 || diff < 0 && preDiff >= 0) {
                ans++;
                preDiff = diff;
            }
        }
        return ans;
    }
}
