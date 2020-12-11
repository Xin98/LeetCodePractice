package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/11
 */

public class Q1450_Number_of_Students_Doing_Homework_at_a_Given_Time {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }
}
