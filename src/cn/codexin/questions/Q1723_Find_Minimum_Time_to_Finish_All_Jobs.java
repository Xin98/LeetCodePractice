package cn.codexin.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by xinGao 2021/5/8
 */

public class Q1723_Find_Minimum_Time_to_Finish_All_Jobs {
    // method1: backtrack
//    public int minimumTimeRequired(int[] jobs, int k) {
//        // sort with reversed order
//        jobs = Arrays.stream(jobs).boxed().sorted((x, y) -> y - x).flatMapToInt(x -> IntStream.of(x)).toArray();
//        int left = jobs[0], right = Arrays.stream(jobs).sum();
//        while(left < right) {
//            int mid = ((right - left) >> 1) + left;
//            if(check(jobs, k, mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//         return left;
//    }
//
//    private boolean check(int[] jobs, int k, int limit) {
//        int[] workers = new int[k];
//        return backtrack(jobs, workers, 0, limit);
//    }
//
//    private boolean backtrack(int[] jobs, int[] workers, int i, int limit) {
//        if(i >= jobs.length) {
//            return true;
//        }
//        int n = workers.length;
//        int cur = jobs[i];
//        for(int j = 0; j < n; j++) {
//            if(workers[j] + cur <= limit) {
//                workers[j] += cur;
//                if(backtrack(jobs, workers, i + 1, limit)) {
//                    return true;
//                }
//                workers[j] -= cur;
//            }
//            if(workers[j] == 0 || workers[j] + cur == limit) {
//                break;
//            }
//        }
//        return false;
//    }

    // method2 dp + state compression
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[] sum = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            int x = Integer.numberOfTrailingZeros(i), y = i - (1 << x);
            sum[i] = sum[y] + jobs[x];
        }
        int[][] dp = new int[k][1 << n];
        for (int i = 0; i < 1 << n; i++) {
            dp[0][i] = sum[i];
        }
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < 1 << n; j++) {
                int min = Integer.MAX_VALUE;
                for(int x = j; x != 0; x = (x - 1) & j){
                    min = Math.min(min, Math.max(dp[i - 1][j - x], sum[x]));
                }
                dp[i][j] = min;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }
}
