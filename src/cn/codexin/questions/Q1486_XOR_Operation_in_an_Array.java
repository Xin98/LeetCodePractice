package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/7
 */

public class Q1486_XOR_Operation_in_an_Array {
    private int sumXOR(int x) {
        if(x % 4 == 0) {
            return x;
        }
        if(x % 4 == 1) {
            return 1;
        }
        if(x % 4 == 2) {
            return x + 1;
        }
        return 0;
    }
    public int xorOperation(int n, int start) {
        int s = start >> 1, e = n & start & 1;
        int ret = sumXOR(s - 1) ^ sumXOR(s + n - 1);
        return ret << 1 | e;
    }

}
