package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/19
 */

public class Q1004_Max_Consecutive_Ones_III {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int revCnt = 0, ans = 0;
        int begin = 0, end = 0;
        for (; end < n; end++) {
            if(A[end] == 1) {
                continue;
            }
            ans = Math.max(end - begin, ans);
            revCnt++;
            A[end] = 2;
            while(revCnt > K) {
                if(A[begin] == 2) {
                    revCnt--;
                    A[begin] = 0;
                }
                begin++;
            }
        }
        ans = Math.max(end - begin, ans);
        return ans;
    }
}
