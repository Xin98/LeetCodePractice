package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/20
 */

public class Q0167_Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        if(lo >= hi) {
            return new int[]{};
        }
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if(sum == target) {
                return new int[] {lo+1, hi+1};
            } else if(sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return new int[]{};
    }
}
