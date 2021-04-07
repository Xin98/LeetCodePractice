package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/7
 */

public class Q0081_Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[lo] == nums[mid] && nums[hi] == nums[mid]) {
                lo++;
                hi--;
            } else if(nums[lo] <= nums[mid]) {
                if(nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}
