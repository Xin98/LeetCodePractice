package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/1
 */

public class Q1526_Minimum_Number_of_Increments_on_Subarrays_to_Form_a_Target_Array {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int ans = target[0];
        for(int i = 1; i < n; i++) {
            ans += Math.max(0, target[i] - target[i-1]);
        }
        return ans;
    }
}
