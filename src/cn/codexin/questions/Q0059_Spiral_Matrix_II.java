package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/16
 */

public class Q0059_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if(n == 0) {
            return ans;
        }
        int count = (n + 1) / 2;
        int m = 1;
        for(int i = 0; i < count; i++) {
            for(int j = i; j < n - i; j++) {
                ans[i][j] = m++;
            }
            for(int j = i + 1; j < n - i; j++) {
                ans[j][n - i - 1] = m++;
            }
            for(int j = n - i - 2; j > i && (i != n - i - 1); j--) {
                ans[n - i - 1][j] = m++;
            }
            for(int j = n - i - 1; j > i && (i != n - i - 1); j--) {
                ans[j][i] = m++;
            }
        }
        return ans;
    }
}
