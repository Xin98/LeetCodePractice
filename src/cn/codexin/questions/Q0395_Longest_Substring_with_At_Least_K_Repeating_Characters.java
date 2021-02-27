package cn.codexin.questions;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by xinGao 2021/2/27
 */

public class Q0395_Longest_Substring_with_At_Least_K_Repeating_Characters {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int start = 0, end = 0;
            int[] cnt = new int[26];
            int unsatisfiedCnt = 0;
            int total = 0;
            for (; end < n; end++) {
                int endIdx = s.charAt(end) - 'a';
                cnt[endIdx]++;
                if(cnt[endIdx] == 1) {
                    total++;
                    unsatisfiedCnt++;
                }
                if(cnt[endIdx] == k) {
                    unsatisfiedCnt--;
                }
                while(total > t) {
                    int startIdx = s.charAt(start) - 'a';
                    cnt[startIdx]--;
                    if(cnt[startIdx] == 0) {
                        total--;
                        unsatisfiedCnt--;
                    }
                    if(cnt[startIdx] == k - 1) {
                        unsatisfiedCnt++;
                    }
                    start++;
                }
                if(unsatisfiedCnt == 0) {
                    ans = Math.max(ans, end - start + 1);
                }
            }
        }
        return ans;
    }
}
