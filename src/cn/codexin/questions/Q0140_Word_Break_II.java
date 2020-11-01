package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/11/1
 */

public class Q0140_Word_Break_II {
    private List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        ans = new LinkedList<>();
        if(n == 0) {
            return ans;
        }
        Set<String> wordSet = new HashSet<>();
        for(String word: wordDict) {
            wordSet.add(word);
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int rignt = 1; rignt <= n; rignt++) {
            for(int left = rignt - 1; left >= 0; left--) {
                if(wordSet.contains(s.substring(left, rignt)) && dp[left]) {
                    dp[rignt] = true;
                    break;
                }
            }
        }
        if(dp[n]) {
            dfs(wordSet, dp, s, new ArrayDeque<>(), n);
        }
        return ans;
    }

    public void dfs(Set<String> wordSet, boolean[] dp, String s, Deque<String> path, int len) {
        if(len == 0) {
            ans.add(String.join(" ", path));
        }
        for(int i = len - 1; i >= 0; i--) {
            String word = s.substring(i, len);
            if(!dp[i] || !wordSet.contains(word)) {
                continue;
            }
            path.push(word);
            dfs(wordSet, dp, s, path, i);
            path.pop();
        }
    }
}
