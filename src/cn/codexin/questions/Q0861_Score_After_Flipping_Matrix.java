package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/7
 */

public class Q0861_Score_After_Flipping_Matrix {
    public int matrixScore(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int ans = 0;
        ans += n * (1 << (m - 1));
        for(int j = 1; j < m; j++) {
            int nOnes = 0;
            for(int i = 0; i < n; i++) {
                if(A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += (1 - A[i][j]);
                }
            }
            int k = Math.max(nOnes, n - nOnes);
            ans += k * (1 << (m - j - 1));
        }
        return ans;
    }
}
