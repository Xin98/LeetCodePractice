package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/20
 */

public class Q0316_Remove_Duplicate_Letters {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        int len = 0;
        for(char c : s.toCharArray()) {
            if(freq[c - 'a'] == 0) {
                len++;
            }
            freq[c - 'a']++;
        }
        char[] stack = new char[len];
        int top = -1;
        for(char c : s.toCharArray()) {
            int idx = c - 'a';
            if(!vis[idx]) {
                while(top != -1 && stack[top] > c && freq[stack[top] - 'a'] > 0) {
                    vis[stack[top--] - 'a'] = false;
                }
                stack[++top] = c;
                vis[idx] = true;
            }
            freq[idx]--;
        }
        return String.valueOf(stack);
    }
}
