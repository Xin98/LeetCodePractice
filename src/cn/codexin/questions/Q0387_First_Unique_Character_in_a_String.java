package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/23
 */

public class Q0387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int ans = n;
        for(int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < n; i++) {
            if(freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
