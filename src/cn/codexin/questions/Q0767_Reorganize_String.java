package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/30
 */

public class Q0767_Reorganize_String {
    public String reorganizeString(String S) {
        int n = S.length();
        if(n < 2) {
            return S;
        }
        int[] freq = new int[26];
        for(char c : S.toCharArray()) {
            freq[c - 'a']++;
            if(freq[c - 'a'] > (n + 1) / 2) {
                return "";
            }
        }
        char[] ans = new char[n];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = n / 2;
        for(int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            while(freq[i] > 0 && freq[i] <= halfLength && oddIndex < n) {
                ans[oddIndex] = c;
                oddIndex += 2;
                freq[i]--;
            }
            while(freq[i] > 0) {
                ans[evenIndex] = c;
                evenIndex += 2;
                freq[i]--;
            }
        }
        return String.valueOf(ans);
    }
}
