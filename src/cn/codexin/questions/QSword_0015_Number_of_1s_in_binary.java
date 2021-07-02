package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/23
 */

public class QSword_0015_Number_of_1s_in_binary {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}
