package cn.codexin.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xinGao 2020/11/11
 */

public class Q0514_Freedom_Trail {
    public int findRotateSteps(String ring, String key) {
        int len1 = ring.length();
        int len2 = key.length();
        List<Integer>[] pos = new List[26];
        for(int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for(int i = 0; i < len1; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[2][len1];
        for(int i = 0; i <= 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for(int i : pos[key.charAt(0) - 'a']) {
            dp[1][i] = Math.min(i, len1 - i) + 1;
        }
        for(int i = 1; i < len2; i++) {
            for(int j : pos[key.charAt(i) - 'a']) {
                for(int k : pos[key.charAt(i-1) - 'a']) {
                    int len = Math.abs(j - k);
                    dp[0][j] = Math.min(dp[0][j], dp[1][k] + Math.min(len, len1 - len) + 1);
                }
            }
            for(int j = 0; j < len1; j++) {
                dp[1][j] = dp[0][j];
                dp[0][j] = Integer.MAX_VALUE / 2;
            }
        }
        return Arrays.stream(dp[1]).min().getAsInt();
    }

    public static void main(String[] args) {
        Q0514_Freedom_Trail Q = new Q0514_Freedom_Trail();
        Q.findRotateSteps("godding", "gdi");
    }
}
