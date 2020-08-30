package cn.codexin.questions;

import com.sun.deploy.util.StringUtils;

/**
 * Created by xinGao 2020/8/30
 */

public class Q0557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') {
                StringBuilder tmp = new StringBuilder(" " + s.substring(left, i));
                ans.append(tmp.reverse().toString());
                left = i + 1;
            }
        }
        if(left != n) {
            StringBuilder tmp = new StringBuilder(s.substring(left));
            ans.append(tmp.reverse().toString());
        }
        return ans.toString();
    }
}
