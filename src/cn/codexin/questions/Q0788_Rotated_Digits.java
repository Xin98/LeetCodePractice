package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/29
 */

public class Q0788_Rotated_Digits {
    public int rotatedDigits(int N) {
        char[] digits = String.valueOf(N).toCharArray();
        int len = digits.length;
        int[][][] memo = new int[len + 1][2][2];
        memo[len][1][1] = memo[len][0][1] = 1;
        for(int i = len - 1; i >= 0; i--) {
            // i 代表着数字的第i位(从高位到低位)
            for(int j = 0; j < 2; j++) {
                // j = 0, 当前数字的前缀(1, i-1)位与N的前缀(1, i-1)位不相等
                // j = 1, 反之相等
                for(int k = 0; k < 2; k++) {
                    // k = 0, (1, i-1)位是否不包含2,5,6,9
                    // k = 1, 反之包含
                    int m = 9;
                    if(j == 1) {
                        m = digits[i] - '0';
                    }
                    int ans = 0;
                    for(int n = 0; n <= m; n++) {
                        if(n == 3 || n == 4 || n == 7) {
                            continue;
                        }
                        boolean inv = (n == 2) || (n == 5) || (n == 6) || (n == 9);
                        ans += memo[i+1][(n==(digits[i]-'0'))? j: 0][inv? 1: k];
                    }
                    memo[i][j][k] = ans;
                }
            }
        }
        return memo[0][1][0];
    }
}
