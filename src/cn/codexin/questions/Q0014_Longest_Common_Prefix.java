package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/15
 */

public class Q0014_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String ans = strs[0];
        for (String str : strs) {
            ans = compareAndReduce(ans, str);
        }
        return ans;
    }

    private String compareAndReduce(String ans, String str) {
        char[] ansChar = ans.toCharArray();
        char[] strChar = str.toCharArray();
        int len = Math.min(ansChar.length, strChar.length);
        int i = 0;
        for (i = 0; i < len; i++) {
            if(ansChar[i] != strChar[i]) break;
        }
        return ans.substring(0, i);
    }
}
