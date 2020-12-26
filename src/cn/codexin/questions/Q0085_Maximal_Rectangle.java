package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/12/26
 */

public class Q0085_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        int ans = 0;
        for(int j = 0; j < col; j++) {
            int[] top = new int[row];
            int[] toe = new int[row];
            Arrays.fill(toe, row);
            int[] stack = new int[row];
            int idx = -1;
            for(int i = 0; i < row; i++) {
                while(idx != -1 && left[stack[idx]][j] >= left[i][j]) {
                    toe[stack[idx--]] = i;
                }
                top[i] = idx == -1 ? -1 : stack[idx];
                stack[++idx] = i;
            }
            for(int i = 0; i < row; i++) {
                ans = Math.max(left[i][j] * (toe[i] - top[i] - 1), ans);
            }
        }
        return ans;
    }
}
