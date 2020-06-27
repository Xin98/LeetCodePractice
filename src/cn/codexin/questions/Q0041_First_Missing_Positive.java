package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/27
 */

public class Q0041_First_Missing_Positive {
    //hash  o(n)时间 o(n)空间
//    public int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//        boolean[] hash = new boolean[n+1];
//        for (int num : nums) {
//            if(num <= n) hash[num] = true;
//        }
//        for(int i = 1; i <= n; i++) {
//            if(hash[i] == false) return i;
//        }
//        return n + 1;
//    }
    // o(n)时间 o(1)空间
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= n && nums[i] >= 1 && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}
