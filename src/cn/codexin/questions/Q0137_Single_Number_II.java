package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/30
 */

public class Q0137_Single_Number_II {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);

            }
            if(total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
