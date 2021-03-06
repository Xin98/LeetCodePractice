package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/3
 */

public class Q0338_Counting_Bits {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
