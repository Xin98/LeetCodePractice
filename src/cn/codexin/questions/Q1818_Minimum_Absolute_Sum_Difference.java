package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/7/14
 */

public class Q1818_Minimum_Absolute_Sum_Difference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = (int)1e9 + 7;
        int n = nums1.length;
        int[] tmp = Arrays.copyOf(nums1, n);
        Arrays.sort(tmp);
        int sum = 0, maxd = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            int j = binarySearch(tmp, nums2[i]);
            if(j < n) {
                maxd = Math.max(maxd, diff - (tmp[j] - nums2[i]));
            }
            if(j > 0) {
                maxd = Math.max(maxd, diff - (nums2[i] - tmp[j - 1]));
            }
            sum = (sum + diff) % MOD;
        }
        return (sum - maxd + MOD) % MOD;
    }

    private int binarySearch(int[] tmp, int target) {
        int l = 0, r = tmp.length - 1;
        while (l <= r) {
            int mid = (r - l)/2 + l;
            if(tmp[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
