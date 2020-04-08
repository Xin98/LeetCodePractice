package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/8
 */

public class Q0498_Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        for (int k = 0; k < m + n - 1; k++) {
            //up表示从左下到右上
            boolean up = (k & 1) == 0;
            //确认第k个对角线开始的坐标
            int i = up ? (k < m ? k : m - 1) : (k < n ? 0 : k - n + 1);
            int j = up ? (k < m ? 0 : k - m + 1) : (k < n ? k : n - 1);
            if(up){
                while(i >= 0 && j < n){
                    ans[idx++] = matrix[i--][j++];
                }
            }
            else{
                while(i < m && j >= 0){
                    ans[idx++] = matrix[i++][j--];
                }
            }
        }
        return ans;
    }
}
