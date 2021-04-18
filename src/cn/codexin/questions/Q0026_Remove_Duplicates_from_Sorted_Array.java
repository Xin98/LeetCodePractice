package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/18
 */

public class Q0026_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        int n = nums.length;
        for(; fast < n; fast++) {
            if(nums[fast] != nums[fast - 1]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
