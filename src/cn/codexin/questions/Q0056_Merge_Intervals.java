package cn.codexin.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/4/16
 */

public class Q0056_Merge_Intervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new LinkedList<>();
        int len = intervals.length;
        for(int i = 1; i < len; i++){
            if(intervals[i][0] <= intervals[i-1][1]){
                //合并
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }
            else ans.add(intervals[i-1]);
        }
        if(len != 0) ans.add(intervals[len-1]);
        return ans.toArray(new int[ans.size()][2]);
    }
}
