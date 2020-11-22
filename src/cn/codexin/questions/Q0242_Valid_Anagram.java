package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/22
 */

public class Q0242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            if(--freq[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
