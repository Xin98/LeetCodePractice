package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/24
 */

public class Q0832_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = 1 - A[i][n - 1 - j];
                A[i][n - 1 - j] = 1 - tmp;
            }
        }
        return A;
    }
}
