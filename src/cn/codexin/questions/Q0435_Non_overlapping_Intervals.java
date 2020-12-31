package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/12/31
 */

public class Q0435_Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y)->{return x[0] == y[0] ? x[1] - y[1] : x[0] - y[0];});
        int end = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] interval : intervals) {
            if(interval[0] < end) {
                ans++;
                end = Math.min(end, interval[1]);
            } else {
                end = interval[1];
            }
        }
        return ans;
    }
}
