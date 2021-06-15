package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/15
 */

public class Q0852_Peak_Index_in_a_Mountain_Array {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if(arr[mid] > arr[mid + 1]) {
                right = mid;
            } else if(arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }
}
