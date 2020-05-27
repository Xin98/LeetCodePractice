package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/5/27
 */

public class Q0974_Subarray_Sums_Divisible_by_K {
    //前缀和  hash table
    public int subarraysDivByK(int[] A, int K) {
        int n = A.length;
        Map<Integer, Integer> hash = new HashMap<>();
        int ans = 0;
        int sum = 0;
        hash.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += A[i];
            int mod = (sum % K + K) % K;
            int cnt =  hash.getOrDefault(mod, 0);
            ans += cnt;
            hash.put(sum, cnt + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q0974_Subarray_Sums_Divisible_by_K Q = new Q0974_Subarray_Sums_Divisible_by_K();
        Q.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5);
    }
}
