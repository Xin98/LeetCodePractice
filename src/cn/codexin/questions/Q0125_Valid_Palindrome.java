package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/19
 */

public class Q0125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if(!Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
