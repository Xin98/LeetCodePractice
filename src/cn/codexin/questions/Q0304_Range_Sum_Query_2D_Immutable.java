package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/2
 */

public class Q0304_Range_Sum_Query_2D_Immutable {
    class NumMatrix {
        private int[][] preSum;
        private int m;
        private int n;
        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            if(m == 0) {
                return;
            }
            n = matrix[0].length;
            if(n == 0) {
                return;
            }
            preSum = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    preSum[i][j] += preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(m == 0 || n == 0) {
                return 0;
            }
            int minRow = Math.min(row1, row2);
            int maxRow = Math.max(row1, row2) + 1;
            int minCol = Math.min(col1, col2);
            int maxCol = Math.max(col1, col2) + 1;
            return preSum[maxRow][maxCol] + preSum[minRow][minCol] - preSum[maxRow][minCol] - preSum[minRow][maxCol];
        }
    }
    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
}
