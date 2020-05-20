package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/5/20
 */

public class Q1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts {
    // 前缀和 + hash + 状态压缩
    public int findTheLongestSubstring(String s) {
        int[] pos = new int[1<<5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        int ans = 0, n = s.length(), status = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == 'a') status ^= (1<<0);
            else if(c == 'e') status ^= (1<<1);
            else if(c == 'i') status ^= (1<<2);
            else if(c == 'o') status ^= (1<<3);
            else if(c == 'u') status ^= (1<<4);
            if(pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}
