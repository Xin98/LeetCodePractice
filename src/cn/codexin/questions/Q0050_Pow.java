package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/5/11
 */

public class Q0050_Pow {

    //快速幂 + 迭代
    public double quickMul(double x, long n){
        double ans = 1;
        while(n > 0){
            if((n & 1) != 0) ans = ans * x;
            x = x * x;
            n = n >> 1;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : quickMul(1 / x, -n);
    }
}
