package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/18
 */

public class Q0483_Smallest_Good_Base {
    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) (Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long sum = 1, mul = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if(sum == nVal) {
                return String.valueOf(k);
            }
        }
        return String.valueOf(nVal - 1);
    }
}
