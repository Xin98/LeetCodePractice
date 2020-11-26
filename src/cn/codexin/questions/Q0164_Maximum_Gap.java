package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/11/26
 */

public class Q0164_Maximum_Gap {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return 0;
        }
        int[] buff = new int[n];
        int exp = 1;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        while(maxValue >= exp) {
            int[] cnt = new int[10];
            for(int i = 0; i < n; i++) {
                int digit = (nums[i] / exp) % 10;
                cnt[digit]++;
            }
            for(int i = 1; i < 10; i++) {
                cnt[i] += cnt[i-1];
            }
            for(int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                buff[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buff, 0, nums, 0, n);
            exp *= 10;
        }
        int ans = 0;
        for(int i = 1; i < n; i++) {
            ans = Math.max(ans, Math.abs(buff[i] - buff[i-1]));
        }
        return ans;
    }
}
