package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/10
 */

public class Q0263_Ugly_Number {
    public boolean isUgly(int n) {
        while(n > 6) {
            if(n % 2 == 0) {
                n /= 2;
            } else if(n % 3 == 0) {
                n /= 3;
            } else if(n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return n > 0;
    }
}
