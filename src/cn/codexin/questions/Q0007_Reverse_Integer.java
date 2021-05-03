package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/3
 */

public class Q0007_Reverse_Integer {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0) {
            if(ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + x % 10;
            x /= 10;

        }
        return ans;
    }

}
