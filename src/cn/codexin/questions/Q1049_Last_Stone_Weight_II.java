package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/6/8
 */

public class Q1049_Last_Stone_Weight_II {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int max = sum / 2;
        boolean[] dp = new boolean[max + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int i = max; i >= stone; i--) {
                dp[i] = dp[i] | dp[i - stone];
            }
        }
        for (int i = max; i >= 0; i--) {
            if(dp[i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }
}
