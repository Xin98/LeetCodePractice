package cn.codexin.questions;

import java.util.TreeSet;

/**
 * Created by xinGao 2021/4/22
 */

public class Q0363_Max_Sum_of_Rectangle_No_Larger_Than_K {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            // top border --> i
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                // bottom border --> j
                for (int t = 0; t < n; t++) {
                    sum[t] += matrix[j][t];
                }
                int s = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int v : sum) {
                    s += v;
                    Integer ceiling = set.ceiling(s - k);
                    if(ceiling != null) {
                        ans = Math.max(ans, s - ceiling);
                    }
                    set.add(s);
                }
            }
        }
        return ans;
    }
}
