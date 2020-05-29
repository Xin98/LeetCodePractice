package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/29
 */

public class Q0191_Number_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0) {
            ans += (n & 1);
            n = n >>> 1;
        }
        return ans;
    }

}
