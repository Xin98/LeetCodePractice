package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/16
 */

public class Q0977_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        for(int i = 0,j = n - 1, idx = n - 1; i <= j;) {
            if(A[i] * A[i] >= A[j] * A[j]) {
                res[idx--] = A[i] * A[i];
                i++;
            } else {
                res[idx--] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }
}
