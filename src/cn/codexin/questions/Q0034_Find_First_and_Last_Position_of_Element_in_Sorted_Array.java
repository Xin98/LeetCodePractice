package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/1
 */

public class Q0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] pos = new int[2];
        pos[0] = -1;
        pos[1] = -1;
        if(len == 0) {
            return pos;
        }
        int mid = binarySearch(nums, target, len);
        if(mid == -1) {
            return pos;
        }
        pos[0] = getBound(nums, target, 0, mid, true);
        pos[1] = getBound(nums, target, mid, len - 1, false);
        return pos;
    }
    public int binarySearch(int[] nums, int target, int len) {
        int lo = 0, hi = len - 1;
        while(lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if(target == nums[mid]) {
                return mid;
            }
            else if(target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int getBound(int[] nums, int target, int lo, int hi, boolean lowBound) {
        while(lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if(target > nums[mid]) {
                lo = mid + 1;
            } else if(target < nums[mid]) {
                hi = mid - 1;
            } else {
                if(lowBound) {
                    hi = mid;
                } else {
                    if(nums[mid + 1] != target) {
                        return mid;
                    }
                    lo = mid + 1;
                }
            }
        }
        return lo;
    }
}
