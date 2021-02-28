package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/28
 */

public class Q0896_Monotonic_Array {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        int flag = 0;
        if(A[n - 1] > A[0]) {
            flag = 1;
        } else if(A[n - 1] < A[0]) {
            flag = -1;
        }
        for(int i = 1; i < n; i++) {
            if(flag == 1 && A[i] < A[i - 1]) {
                return false;
            }
            if(flag == -1 && A[i] > A[i - 1]) {
                return false;
            }
            if(flag == 0 && A[i] != A[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
