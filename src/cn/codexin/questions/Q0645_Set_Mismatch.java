package cn.codexin.questions;

/**
 * Created by xinGao 2021/7/4
 */

public class Q0645_Set_Mismatch {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        int lowbit = (-xor) & xor;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if((num & lowbit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if((i & lowbit) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        for (int num : nums) {
            if(num1 == num) {
                return new int[]{num1, num2};
            }
        }
        return new int[]{num2, num1};
    }
}
