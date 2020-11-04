package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/11/4
 */

public class Q0057_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new LinkedList<>();
        int len = intervals.length;
        int i = 0;
        for(; i < len; i++) {
            if(intervals[i][1] < newInterval[0]) {
                ans.add(intervals[i]);
                continue;
            }
            if(intervals[i][0] > newInterval[1]) {
                break;
            }
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }
        ans.add(newInterval);
        for(; i < len; i++) {
            ans.add(intervals[i]);
        }
        int[][] res = new int[ans.size()][];
        for(int j = 0; j < ans.size(); j++) {
            res[j] = ans.get(j);
        }
        return res;
    }
}
