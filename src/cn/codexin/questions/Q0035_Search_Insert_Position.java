package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/17
 */

public class Q0035_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    public int binarySearch(int[] nums, int target, int lo, int hi) {
        if(lo > hi) {
            return lo;
        }
        int mid = (hi - lo) / 2 + lo;
        if(target == nums[mid]) {
            return mid;
        } else if(target < nums[mid]) {
            return binarySearch(nums, target, lo , mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, hi);
        }
    }
}
