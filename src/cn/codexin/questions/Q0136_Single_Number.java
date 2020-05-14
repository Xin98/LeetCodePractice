package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/14
 */

public class Q0136_Single_Number {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
