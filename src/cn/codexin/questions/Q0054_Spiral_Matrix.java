package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/3/15
 */

public class Q0054_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int m = matrix.length;
        if(m == 0) {
            return ans;
        }
        int n = matrix[0].length;
        if(n == 0) {
            return ans;
        }
        int count = (Math.min(m, n) + 1) / 2;
        for(int i = 0; i < count; i++) {
            for(int j = i; j < n - i; j++) {
                ans.add(matrix[i][j]);
            }
            for(int j = i + 1; j < m - i; j++) {
                ans.add(matrix[j][n - i - 1]);
            }
            for(int j = n - i - 2; j > i && (i != m - i - 1); j--) {
                ans.add(matrix[m - i - 1][j]);
            }
            for(int j = m - i - 1; j > i && (i != n - i - 1); j--) {
                ans.add(matrix[j][i]);
            }
        }
        return ans;
    }
}
