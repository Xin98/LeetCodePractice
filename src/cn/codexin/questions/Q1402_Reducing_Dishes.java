package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/12/8
 */

public class Q1402_Reducing_Dishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0;
        int n = satisfaction.length;
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + satisfaction[i - 1];
        }
        int i = 0;
        for(; i < n; i++) {
            if(preSum[i] < preSum[n]) {
                break;
            }
        }
        for(int j = i; j < n; j++) {
            ans += satisfaction[j] * (j - i + 1);
        }
        return ans;
    }
}
