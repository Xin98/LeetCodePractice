package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/9
 */

public class Q0992_Subarrays_with_K_Different_Integers {
    public int subarraysWithKDistinct(int[] A, int K) {
        return helper(A, K) - helper(A, K - 1);
    }
    public int helper(int[] A, int K) {
        int ans = 0, cnt = 0;
        int n = A.length;
        int[] hash = new int[n + 1];
        for(int begin = 0, end = 0; end < n; end++) {
            if(hash[A[end]] == 0) {
                cnt++;
            }
            hash[A[end]]++;
            while(cnt > K) {

                if(hash[A[begin]] == 1) {
                    cnt--;
                }
                hash[A[begin]]--;
                begin++;
            }
            ans += end - begin + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q0992_Subarrays_with_K_Different_Integers Q = new Q0992_Subarrays_with_K_Different_Integers();
        Q.helper(new int[]{1,2,1,2,3}, 2);
    }
}
