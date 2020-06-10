package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/10
 */

public class Q0009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int y = 0;
        while(x > y) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return x == y || x == y / 10;
    }

}
