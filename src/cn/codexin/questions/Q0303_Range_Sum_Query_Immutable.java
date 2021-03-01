package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/1
 */

public class Q0303_Range_Sum_Query_Immutable {
    class NumArray{
        private int[] preSum;
        public NumArray(int[] nums) {
            int n = nums.length;
            preSum = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                preSum[i] += preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return preSum[j + 1] - preSum[i];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
}
