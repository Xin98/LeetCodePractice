package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/5
 */

public class Q1208_Get_Equal_Substrings_Within_Budget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int cost = 0;
        int ans = 0;
        for(int begin = 0, end = 0; end < n; end++) {
            cost += Math.abs(t.charAt(end) - s.charAt(end));
            while(cost > maxCost) {
                cost -= Math.abs(t.charAt(begin) - s.charAt(begin));
                begin++;
            }
            ans = Math.max(ans, end - begin + 1);
        }
        return ans;
    }
}
