package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/27
 */

public class Q0392_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int i = 0;
        int n = s.length();
        for (char c : tCharArray) {
            if(i == n) {
                return true;
            }
            if(sCharArray[i] == c) {
                i++;
            }
        }
        return false;
    }
}
