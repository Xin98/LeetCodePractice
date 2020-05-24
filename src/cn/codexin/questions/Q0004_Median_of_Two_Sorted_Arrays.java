package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/24
 */

public class Q0004_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 > len2) return findMedianSortedArrays(nums2, nums1);

        int medium1 = 0, medium2 = 0;
        int left = 0, right = len1;
        while(left <= right) {
            int i = (left + right) / 2;
            int j = (len1 + len2 + 1) / 2  - i;

            int nums_i1 = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
            int nums_j1 = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
            int nums_i = i == len1 ? Integer.MAX_VALUE : nums1[i];
            int nums_j = j == len2 ? Integer.MAX_VALUE : nums2[j];

            // nums1[i-1] <= nums2[j] ==> nums2[j-1] <= nums1[i]
            if(nums_i1 <= nums_j) {
                left = i + 1;
                medium1 = Math.max(nums_i1, nums_j1);
                medium2 = Math.min(nums_i, nums_j);

            } else {
                right = i - 1;
            }

        }
        return (len1 + len2) % 2 == 0 ? (medium1 + medium2) / 2.0 : medium1;
    }

}
