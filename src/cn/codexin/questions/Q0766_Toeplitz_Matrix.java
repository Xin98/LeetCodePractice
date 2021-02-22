package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/22
 */

public class Q0766_Toeplitz_Matrix {
    private int n;
    private int m;
    public boolean isToeplitzMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            if(!helper(matrix, i, 0)) {
                return false;
            }
        }
        for(int i = 0; i < n; i++) {
            if(!helper(matrix, 0, i)) {
                return false;
            }
        }
        return true;
    }
    public boolean helper(int[][] matrix, int x, int y) {
        int num = matrix[x][y];
        while(x < m && y < n) {
            if(matrix[x][y] != num) {
                return false;
            }
            x++;
            y++;
        }

        return true;
    }
}
