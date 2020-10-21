package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/21
 */

public class Q0925_Long_Pressed_Name {
    public boolean isLongPressedName(String name, String typed) {
        if(name.equals(typed)) {
            return true;
        }
        int n = name.length(), m = typed.length();
        if(n >= m) {
            return false;
        }
        int j = 0;
        for(int i = 0; i < m; i++) {
            if(j < n && typed.charAt(i) == name.charAt(j)) {
                j++;
            } else if(i == 0 || typed.charAt(i - 1) != typed.charAt(i)) {
                return false;
            }
        }
        return j == n;
    }
}
