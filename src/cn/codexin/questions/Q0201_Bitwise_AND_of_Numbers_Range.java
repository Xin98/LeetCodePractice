package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/23
 */

public class Q0201_Bitwise_AND_of_Numbers_Range {
    //0 0 0 0
    //0 0 0 1
    //0 0 1 0
    //0 0 1 1
    //0 1 0 0
    //0 1 0 1
    //0 1 1 0
    //0 1 1 1
    public int rangeBitwiseAnd(int m, int n) {
        while(m < n) {
            n = n & (n - 1);
        }
        return n;
    }
}
