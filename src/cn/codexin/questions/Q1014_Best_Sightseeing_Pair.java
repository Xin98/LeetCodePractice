package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/17
 */

public class Q1014_Best_Sightseeing_Pair {
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int mx = A[0] + 0;
        for(int j = 1; j < A.length; j++) {
            ans = Math.max(ans, mx + A[j] - j);
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }
}
