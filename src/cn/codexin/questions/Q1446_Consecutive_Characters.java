package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/16
 */

public class Q1446_Consecutive_Characters {
    public int maxPower(String s) {
        int ans = 1;
        int n = s.length();
        int cnt = 1;
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                cnt++;
            } else {
                ans = Math.max(cnt, ans);
                cnt = 1;
            }
        }
        ans = Math.max(cnt, ans);
        return ans;
    }
}
