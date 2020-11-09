package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/9
 */

public class Q0327_Count_of_Range_Sum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long[] sum = new long[len + 1];
        for(int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return countRangeSumRecursive(sum, 0, len, lower, upper);
    }
    public int countRangeSumRecursive(long[] sum, int left, int right, int lower, int upper) {
        if(left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int lc = countRangeSumRecursive(sum, left, mid, lower, upper);
        int rc = countRangeSumRecursive(sum, mid + 1, right, lower, upper);
        int ret = lc + rc;
        long[] sorted = new long[right - left + 1];
        int t = left;
        int l = mid + 1;
        int r = mid + 1;
        while(t <= mid) {
            while(l <= right && sum[l] - sum[t] < lower) {
                l++;
            }
            while(r <= right && sum[r] - sum[t] <= upper) {
                r++;
            }
            ret += r - l;
            t++;
        }
        int i = left, j = mid + 1;
        for(int k = 0; k <= right - left; k++) {
            if(i > mid) {
                sorted[k] = sum[j++];
            } else if(j > right) {
                sorted[k] = sum[i++];
            } else {
                if(sum[i] <= sum[j]) {
                    sorted[k] = sum[i++];
                } else {
                    sorted[k] = sum[j++];
                }
            }
        }
        for(int k = 0; k <= right - left; k++) {
            sum[left + k] = sorted[k];
        }
        return ret;
    }
}
