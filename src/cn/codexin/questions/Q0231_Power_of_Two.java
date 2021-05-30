package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/30
 */

public class Q0231_Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && n == (n & (-n));
    }
}
