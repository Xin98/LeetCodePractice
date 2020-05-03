package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/3
 */

public class Q0172_Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n >= 5){
            ans += n/5;
            n = n/5;
        }
        return ans;
    }
}
