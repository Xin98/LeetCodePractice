package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/28
 */

public class Q1343_Number_of_Sub_arrays_of_Size_K_and_Average_Greater_than_or_Equal_to_Threshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if(arr.length < k) {
            return 0;
        }
        int sum = 0, minSum = k * threshold, ans = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if(sum >= minSum) {
            ans++;
        }
        for(int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            if(sum >= minSum) {
                ans++;
            }
        }
        return ans;
    }
}
