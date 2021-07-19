package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/7/19
 */

public class Q1838_Frequency_of_the_Most_Frequent_Element {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int ans = 1;
        for (int left = 0, right = 1; right < n; right++) {
            long sum = preSum[right] - preSum[left];
            while (left < right && (sum + k) / (right - left) < nums[right]) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
