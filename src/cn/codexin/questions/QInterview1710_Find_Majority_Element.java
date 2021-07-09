package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/7/9
 */

public class QInterview1710_Find_Majority_Element {
    public int majorityElement(int[] nums) {
        int candidates = 0, count = 0, n = nums.length;
        for (int num : nums) {
            if(count == 0) {
                candidates = num;
                count++;
            } else if(candidates == num) {
                count++;
            } else {
                count--;
            }
        }
        int finalCandidates = candidates;
        return Arrays.stream(nums).filter(x -> x == finalCandidates).count() > n / 2? candidates: -1;
    }

    public static void main(String[] args) {
        QInterview1710_Find_Majority_Element Q = new QInterview1710_Find_Majority_Element();
        Q.majorityElement(new int[]{3, 3, 4});
    }
}
