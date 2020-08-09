package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/10
 */

public class Q0696_Count_Binary_Substrings {
    public int countBinarySubstrings(String s) {
        int lastDiffCharCnt = 0;
        char lastChar = '0';
        int cnt = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(lastChar == s.charAt(i)) {
                cnt++;
            } else {
                ans += Math.min(cnt, lastDiffCharCnt);
                lastDiffCharCnt = cnt;
                lastChar = s.charAt(i);
                cnt = 1;
            }
        }
        ans += Math.min(cnt, lastDiffCharCnt);
        return ans;
    }
}
