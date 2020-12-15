package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/15
 */

public class Q0738_Monotone_Increasing_Digits {
    public int monotoneIncreasingDigits(int N) {
        int ans = 0;
        String s = String.valueOf(N);
        int lastDigit = 0;
        for(int i = 0; i < s.length(); i++) {
            int curDigit = s.charAt(i) - '0';
            if(curDigit < lastDigit) {
                ans = transform(ans);
                for(int j = i; j < s.length(); j++) {
                    ans *= 10;
                    ans += 9;
                }
                return ans;
            } else {
                ans *= 10;
                ans += curDigit;
            }
            lastDigit = curDigit;
        }
        return ans;
    }
    public int transform(int n) {
        if(n == 0) {
            return 0;
        }
        if(n < 10) {
            return n - 1;
        }
        if(n % 10 > (n /10) % 10) {
            return n - 1;
        }
        return transform(n / 10) * 10 + 9;
    }
}
