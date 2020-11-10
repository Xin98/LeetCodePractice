package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/10
 */

public class Q0031_Next_Permutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1) {
            return;
        }
        int i = n - 2;
        while(i > 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        int j = n - 1;
        for(; j > i; j--) {
            if(nums[j] > nums[i]) {
                break;
            }
        }
        System.out.println(i+":"+j);
        if(i != j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            j = i + 1;
        }
        for(int k = 0; k < (n - j) / 2; k++) {
            int tmp = nums[j + k];
            nums[j + k] = nums[n - 1 - k];
            nums[n - 1 - k] = tmp;
        }
    }
}
