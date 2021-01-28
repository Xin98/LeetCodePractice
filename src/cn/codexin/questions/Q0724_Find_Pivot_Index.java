package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/28
 */

public class Q0724_Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return -1;
        }
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int subSum = 0;
        for(int i = 0; i < n; i++) {
            subSum += (i == 0? 0: nums[i - 1]);
            if(2 * subSum == sum - nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
