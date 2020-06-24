package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/6/24
 */

public class Q0016_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 10000;
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i+1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return target;
                if(Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                 if(sum > target) {
                    int k0 = k - 1;
                    while(k0 > j && nums[k0] == nums[k]) k0--;
                    k = k0;
                }
                 else if(sum < target) {
                    int j0 = j + 1;
                    while(j0 < k && nums[j0] == nums[j]) j0++;
                    j = j0;
                }
            }
        }
        return ans;
    }

}
