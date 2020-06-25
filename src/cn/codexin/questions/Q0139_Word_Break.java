package cn.codexin.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xinGao 2020/6/25
 */

public class Q0139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        int maxLen = 0, minLen = Integer.MAX_VALUE;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
            minLen = Math.min(minLen, word.length());
        }
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= i - minLen  ; j++) {
                if(i - j <= maxLen && dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
