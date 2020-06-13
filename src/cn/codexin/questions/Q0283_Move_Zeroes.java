package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/13
 */

public class Q0283_Move_Zeroes {

    public void moveZeroes(int[] nums) {
        int idx = 0;
        int n = nums.length;
        for (int num : nums) {
            if(num != 0) nums[idx++] = num;
        }
        for(int i = idx; i < n; i++) {
            nums[i] = 0;
        }
    }
}
