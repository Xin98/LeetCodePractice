package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/3
 */

public class Q0204_Count_Primes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int cnt = 0;
        for(int i = 2; i < n; i++) {
            if(notPrime[i]) {
                continue;
            }
            cnt++;
            for(long j = (long) i * i; j < n; j += i) {
                notPrime[(int)j] = true;
            }
        }
        return cnt;
    }
}
