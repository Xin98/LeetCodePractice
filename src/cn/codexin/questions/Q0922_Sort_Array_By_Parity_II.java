package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/12
 */

public class Q0922_Sort_Array_By_Parity_II {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        int i1 = 0, i2 = 1;
        for(int i = 0; i < n; i++) {
            if((A[i] & 1) == 0) {
                ans[i1] = A[i];
                i1 += 2;
            } else {
                ans[i2] = A[i];
                i2 += 2;
            }
        }
        return ans;
    }
}
