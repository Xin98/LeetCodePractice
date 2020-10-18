package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/18
 */

public class Q0567_Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int n = s1.length();
        for(int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        for(int l = 0, r = 0, cnt = 0; r < s2.length(); r++) {
            int idx = s2.charAt(r) - 'a';
            freq[idx]--;
            cnt++;
            if(freq[idx] >= 0) {
                if(cnt == n) {
                    return true;
                }
                continue;
            }
            while(l <= r) {
                freq[s2.charAt(l++) - 'a']++;
                cnt--;
                if(freq[idx] == 0) {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q0567_Permutation_in_String Q = new Q0567_Permutation_in_String();
        Q.checkInclusion("ab", "eidbaooo");
    }
}
