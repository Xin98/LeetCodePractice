package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/8
 */

public class Q0344_Reverse_String {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        for(; l < r; l++, r--) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
        }
    }
}
