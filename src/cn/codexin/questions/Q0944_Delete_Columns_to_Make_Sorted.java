package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/15
 */

public class Q0944_Delete_Columns_to_Make_Sorted {
    public int minDeletionSize(String[] A) {
        int n = A.length;
        if(n == 0) {
            return 0;
        }
        int len = A[0].length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < n; j++) {
                if(A[j].charAt(i) < A[j-1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
