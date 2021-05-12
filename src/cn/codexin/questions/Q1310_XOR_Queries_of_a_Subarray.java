package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/12
 */

public class Q1310_XOR_Queries_of_a_Subarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int length = arr.length + 1;
        int[] sumXOR = new int[length];
        for (int i = 1; i <= length; i++) {
            sumXOR[i] = sumXOR[i - 1] ^ arr[i - 1];
        }
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = queries[i][0], r = queries[i][1] + 1;
            ans[i] = sumXOR[r] ^ sumXOR[l];
        }
        return ans;
    }
}
