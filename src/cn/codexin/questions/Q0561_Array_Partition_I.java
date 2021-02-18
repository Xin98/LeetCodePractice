package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/2/16
 */

public class Q0561_Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i+=2) {
            ans += Math.min(nums[i], nums[i + 1]);
        }
        return ans;
    }
}
