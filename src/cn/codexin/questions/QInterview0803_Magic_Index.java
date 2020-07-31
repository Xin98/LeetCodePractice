package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/31
 */

public class QInterview0803_Magic_Index {
    public int findMagicIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
