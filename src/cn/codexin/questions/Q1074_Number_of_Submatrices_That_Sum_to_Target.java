package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/5/29
 */

public class Q1074_Number_of_Submatrices_That_Sum_to_Target {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    sum[k] += matrix[j][k];
                }
                ans += sumSubMatrix(sum, target);
            }
        }
        return ans;
    }
    private int sumSubMatrix(int[] matrix, int target) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int sum = 0;
        int ans = 0;
        cnt.put(0, 1);
        for (int num : matrix) {
            sum += num;
            ans += cnt.getOrDefault(sum - target, 0);
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
