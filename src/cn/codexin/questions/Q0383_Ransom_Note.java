package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/3
 */

public class Q0383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for(char c : magazine.toCharArray()){
            freq[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            if(--freq[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
