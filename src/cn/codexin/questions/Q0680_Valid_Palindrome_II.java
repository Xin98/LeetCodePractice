package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/19
 */

public class Q0680_Valid_Palindrome_II {
    public boolean validPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        for (; lo < hi; ) {
            char leftChar = s.charAt(lo);
            char rightChar = s.charAt(hi);
            if (leftChar != rightChar) {
                boolean isValid1 = true, isValid2 = true;
                for(int i = lo + 1, j = hi; i < j ; i++,j--) {
                    if(s.charAt(i) == s.charAt(j)) continue;
                    isValid1 = false;
                    break;
                }
                for(int i = lo , j = hi - 1; i < j ; i++,j--) {
                    if(s.charAt(i) == s.charAt(j)) continue;
                    isValid2 = false;
                    break;
                }
                return isValid1 || isValid2;
            } else {
                lo++;
                hi--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q0680_Valid_Palindrome_II Q = new Q0680_Valid_Palindrome_II();
        System.out.println(Q.validPalindrome("ebcbbececabbacecbbcbe"));
    }
}
