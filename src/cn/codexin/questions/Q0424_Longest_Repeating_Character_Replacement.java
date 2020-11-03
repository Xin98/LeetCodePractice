package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/3
 */

public class Q0424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] freq = new int[26];
        int max = 0;
        int ans = 0;
        for(int l = 0, r = 0; r < len; r++) {
            int idx = s.charAt(r) - 'A';
            freq[idx]++;
            max = Math.max(max, freq[idx]);
            if(r - l - max + 1 > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
