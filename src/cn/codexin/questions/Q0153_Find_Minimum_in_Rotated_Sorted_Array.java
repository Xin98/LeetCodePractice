package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/8
 */

public class Q0153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            if(nums[lo] <= nums[hi]) {
                return nums[lo];
            }
            int mid = (hi - lo) / 2 + lo;
            if(nums[mid] >= nums[lo]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return -1;
    }
}
