package cn.codexin.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xinGao 2020/5/6
 */

public class Q0983_Minimum_Cost_For_Tickets {
    //时间变量型
//    private int[] memo;
//    private int[] costs;
//    private Set<Integer> dayset;
//
//    public int mincostTickets(int[] days, int[] costs) {
//        memo = new int[366];
//        this.costs = costs;
//        dayset = new HashSet<>();
//        for (int day : days) {
//            dayset.add(day);
//        }
//        return dp(1);
//    }
//
//    public int dp(int i) {
//        if (i > 365) return 0;
//        if (memo[i] != 0) return memo[i];
//        if (dayset.contains(i)) {
//            memo[i] =  Math.min(costs[0] + dp(i + 1), Math.min(costs[1] + dp(i + 7), costs[2] + dp(i + 30)));
//        } else {
//            memo[i] =  dp(i + 1);
//        }
//        return memo[i];
//    }

    //窗口变量型
    private int[] memo;
    private int[] costs;
    private int[] days;
    private int[] durations = {1, 7, 30};
    public int mincostTickets(int[] days, int[] costs) {
        memo = new int[days.length];
        this.costs = costs;
        this.days = days;
        return dp(0);
    }

    public int dp(int i) {
        if (i >= days.length) return 0;
        if(memo[i] != 0) return memo[i];

        int j = i;
        memo[i] = Integer.MAX_VALUE;
        for(int k = 0; k < 3; k++){
            while(j < days.length && days[j] < days[i] + durations[k]) j++;
            memo[i] = Math.min(memo[i], costs[k] + dp(j));
        }
        return memo[i];
    }
}
