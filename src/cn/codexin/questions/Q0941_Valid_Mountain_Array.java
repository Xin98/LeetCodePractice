package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/3
 */

public class Q0941_Valid_Mountain_Array {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if(len < 3) {
            return false;
        }
        boolean asc = true;
        for(int i = 1; i < len; i++) {
            if(A[i] == A[i-1]) {
                return false;
            }
            if(asc) {
                if(A[i] < A[i-1]) {
                    if(i == 1) {
                        return false;
                    }
                    asc = false;
                }
            } else {
                if(A[i] > A[i-1]) {
                    return false;
                }
            }
        }
        return asc == false;
    }
}
