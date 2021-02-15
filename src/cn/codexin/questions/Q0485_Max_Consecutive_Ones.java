package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/15
 */

public class Q0485_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, cnt = 0;
        for(int num : nums) {
            if(num != 1) {
                ans = Math.max(ans, cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return Math.max(ans, cnt);
    }
}
