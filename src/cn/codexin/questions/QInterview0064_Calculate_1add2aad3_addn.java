package cn.codexin.questions;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by xinGao 2020/6/2
 */

public class QInterview0064_Calculate_1add2aad3_addn {
    //求1+2+…+n 要求不能使用乘除法、for、while、if、else、switch、case
    public int sumNums(int n) {
        return quickMul(n, n+1) >>1;
    }

    public int quickMul(int A, int B) {
        int ans = 0;
        boolean tmp = (B == 0) && (((B & 1) == 1) && (ans += A) > 0);
        tmp = (B == 0) && (ans += quickMul(A<<1, B>>1)) > 0;
        return ans;
    }
}
