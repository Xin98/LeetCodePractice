package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/6/14
 */

public class Q1300_Sum_of_Mutated_Array_Closest_to_Target {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + arr[i - 1];
        }

        int left = 0;
        int right = arr[n - 1];
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int idx = Arrays.binarySearch(arr, mid);
            if(idx < 0) idx = -idx - 1;
            int cur = prefix[idx] + (n - idx) * mid;
            if(cur <= target) {
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        int less = check(arr, ans);
        int more = check(arr, ans + 1);

        return Math.abs(less - target) <= Math.abs(more - target) ? ans : ans + 1;
    }

    private int check(int[] arr, int x) {
        int ans = 0;
        for (int e : arr) {
            ans += Math.min(e, x);
        }
        return ans;
    }

}
