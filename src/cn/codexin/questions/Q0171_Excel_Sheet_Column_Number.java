package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/11
 */

public class Q0171_Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = ans * 26 + (s.charAt(i) - 'A' + 1);
        }
        return ans;
    }
}
