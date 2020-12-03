package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/3
 */

public class QLCP0002_Deep_Dark_Fraction {
    public int[] fraction(int[] cont) {
        int numerator = 0, denominator = 1;
        int n = cont.length;
        for(int i = n - 1; i >= 0; i--) {
            int tmp = numerator +  cont[i] * denominator;
            numerator = denominator;
            denominator = tmp;
        }
        return new int[]{denominator, numerator};
    }
}
