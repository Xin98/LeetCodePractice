package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/12/25
 */

public class Q0455_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = s.length - 1;
        for(int i = g.length - 1; i >= 0; i--) {
            if(j < 0) {
                break;
            }
            if(s[j] >= g[i]) {
                j--;
            }
        }
        return s.length - j - 1;
    }
}
