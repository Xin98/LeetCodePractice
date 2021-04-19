package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/19
 */

public class Q0027_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0, n = nums.length;
        for(; fast < n; fast++) {
            if(nums[fast] == val) {
                continue;
            }
            nums[slow++] = nums[fast];
        }
        return slow;
    }
}
