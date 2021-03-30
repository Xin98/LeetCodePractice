package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/30
 */

public class Q0074_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            int v = getValue(matrix, mid, n);
            if(target == v) {
                return true;
            } else if(target > v) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    private int getValue(int[][] matrix, int pos, int n) {
        return matrix[pos / n][pos % n];
    }
}
