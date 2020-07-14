package cn.codexin.questions;

import java.util.List;

/**
 * Created by xinGao 2020/7/14
 */

public class Q0120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if(j == i) {
                    dp[j] = dp[j-1];
                } else if(j == 0) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]);
                }
                dp[j] += triangle.get(i).get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}
