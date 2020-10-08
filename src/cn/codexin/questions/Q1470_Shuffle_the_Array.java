package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/8
 */

public class Q1470_Shuffle_the_Array {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for(int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[n + i];
        }
        return ans;
    }
}
