package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/31
 */

public class Q0342_Power_of_Four {
    public boolean isPowerOfFour(int n) {
        int m = (int)Math.sqrt(n);
        return (m * m == n) && (m > 0) && (m == (m & -m));
    }
}
