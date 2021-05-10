package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/5/09
 */

public class Q1482_Minimum_Number_of_Days_to_Make_m_Bouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length / k < m) {
            return -1;
        }
        int left = Arrays.stream(bloomDay).min().getAsInt(), right = Arrays.stream(bloomDay).max().getAsInt();
        while(left < right) {
            int mid = ((right - left) >> 2) + left;
            if(canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0, cnt = 0;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= days) {
                cnt++;
                if(cnt == k) {
                    cnt = 0;
                    bouquets++;
                    if(bouquets == m) {
                        return true;
                    }
                }
            } else {
                cnt = 0;
            }
        }
        return false;
    }
}
