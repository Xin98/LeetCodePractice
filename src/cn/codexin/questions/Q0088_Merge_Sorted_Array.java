package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/5
 */

public class Q0088_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        n--;
        m--;
        int cur = nums1.length - 1;
        while(m >= 0 && n >= 0) {
            if(nums1[m] > nums2[n]) {
                nums1[cur] = nums1[m--];
            } else {
                nums1[cur] = nums2[n--];
            }
            cur--;
        }
        while(n >= 0) {
            nums1[cur--] = nums2[n--];
        }
    }
}
