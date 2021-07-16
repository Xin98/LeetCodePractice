package cn.codexin.questions;

/**
 * Created by xinGao 2021/7/16
 */

public class QSword_0053_Find_Num_in_Ordered_Array {
    public int search(int[] nums, int target) {
        int leftBound = binarySearch(nums, target, true);
        int rightBound = binarySearch(nums, target, false);
        if(leftBound <= rightBound && nums[leftBound] == target && nums[rightBound] == target) {
            return rightBound - leftBound + 1;
        } else {
            return 0;
        }
    }
    private int binarySearch(int[] arr, int target, boolean lower) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(arr[mid] > target || (lower && arr[mid] >= target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return lower? left: right;
    }
}
