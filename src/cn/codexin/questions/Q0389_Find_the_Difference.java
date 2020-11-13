package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/13
 */

public class Q0389_Find_the_Difference {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        for(char c : t.toCharArray()) {
            if(--freq[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }
}
