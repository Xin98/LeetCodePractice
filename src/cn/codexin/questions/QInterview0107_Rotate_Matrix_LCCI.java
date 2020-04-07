package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/7
 */

public class QInterview0107_Rotate_Matrix_LCCI {
    //直接旋转
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        for(int i = 0; i < n/2; i++){
//            for(int j = 0; j < (n+1)/2; j++){
//                //旋转块
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[n-1-j][i];
//                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
//                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
//                matrix[j][n-1-i] = tmp;
//            }
//        }
//    }
    //翻转
    public void rotate(int[][] matrix){
        int n = matrix.length;
        //对角线翻转
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //垂直翻转
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n; j++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        QInterview0107_Rotate_Matrix_LCCI qInterview0107_rotate_matrix_lcci = new QInterview0107_Rotate_Matrix_LCCI();
        int[][] m = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        qInterview0107_rotate_matrix_lcci.rotate(m);
    }
}
