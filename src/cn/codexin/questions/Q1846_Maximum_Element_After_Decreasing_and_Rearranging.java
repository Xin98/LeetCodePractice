package cn.codexin.questions;

/**
 * Created by xinGao 2021/7/15
 */

public class Q1846_Maximum_Element_After_Decreasing_and_Rearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int num : arr) {
            if(num > n) {
                cnt[n]++;
            } else {
                cnt[num]++;
            }
        }
        int miss = 0;
        for (int i = 1; i <= n; i++) {
            if(cnt[i] == 0) {
                miss++;
            } else {
                miss -= Math.min(miss, cnt[i] - 1);
            }
        }
        return n - miss;
    }
}
