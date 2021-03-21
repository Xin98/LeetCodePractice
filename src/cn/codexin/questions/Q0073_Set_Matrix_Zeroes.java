package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/21
 */

public class Q0073_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;

        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0) {
                flag = true;
            }
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for(int i = m - 1; i >= 0; i--) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(flag) {
                matrix[i][0] = 0;
            }
        }
    }
}
