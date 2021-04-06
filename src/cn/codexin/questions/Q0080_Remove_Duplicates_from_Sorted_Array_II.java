package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/6
 */

public class Q0080_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int cur = 0, cnt = 1, last = 10001;
        for(int num: nums) {
            if(num == last) {
                cnt++;
            } else {
                cnt = 1;
                last = num;
            }
            if(cnt <= 2) {
                nums[cur++] = num;
            }
        }
        return cur;
    }
}
