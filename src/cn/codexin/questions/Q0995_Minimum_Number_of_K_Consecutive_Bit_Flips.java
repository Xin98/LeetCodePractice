package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/18
 */

public class Q0995_Minimum_Number_of_K_Consecutive_Bit_Flips {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; i++) {
             if(i >= K && A[i - K] > 1) {
                revCnt ^= 1;
                A[i - K] -= 2;
            }
             if(A[i] == revCnt) {
                 if(i + K > n) {
                     return -1;
                 }
                 A[i] += 2;
                 revCnt ^= 1;
                 ans++;
             }
        }
        return ans;
    }
}
