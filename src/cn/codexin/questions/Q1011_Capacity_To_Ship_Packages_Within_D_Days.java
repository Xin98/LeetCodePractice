package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/4/26
 */

public class Q1011_Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int cur = 0, needDays = 1;
            for (int weight : weights) {
                if(cur + weight > mid) {
                    cur = 0;
                    needDays++;
                }
                cur += weight;
            }
            if(needDays > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
