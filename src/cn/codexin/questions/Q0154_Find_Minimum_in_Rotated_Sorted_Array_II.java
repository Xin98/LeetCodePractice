package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/9
 */

public class Q0154_Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if(nums[mid] < nums[hi]) {
                hi = mid;
            } else if(nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi -= 1;
            }
        }
        return nums[lo];
    }
}
