package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/10/8
 */

public class Q0075_Sort_Colors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int[] hash = new int[3];
        for(int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }
        int idx = 0;
        for(int i = 0; i < 3; i++) {
            Arrays.fill(nums, idx, idx + hash[i], i);
            idx += hash[i];
        }
    }
}
