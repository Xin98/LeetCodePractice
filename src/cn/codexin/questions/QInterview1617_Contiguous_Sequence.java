package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/24
 */

public class QInterview1617_Contiguous_Sequence {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
