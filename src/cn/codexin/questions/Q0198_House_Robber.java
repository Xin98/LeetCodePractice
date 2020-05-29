package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/29
 */

public class Q0198_House_Robber {
    public int rob(int[] nums) {
        int pre1 = 0;
        int pre2 = 0;
        for (int num : nums) {
            int tmp = pre2;
            pre2 = Math.max(pre1 + num, pre2);
            pre1 = tmp;
        }
        return Math.max(pre1, pre2);
    }
}
