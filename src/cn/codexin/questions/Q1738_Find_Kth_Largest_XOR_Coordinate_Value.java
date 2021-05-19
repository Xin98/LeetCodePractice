package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/19
 */

public class Q1738_Find_Kth_Largest_XOR_Coordinate_Value {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        int[] data = new int[m * n];
        int idx = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i-1][j] ^ pre[i][j-1] ^ pre[i-1][j-1] ^ matrix[i-1][j-1];
                data[idx++] = pre[i][j];
            }
        }
        quickSelectNthElement(data, 0, m * n - 1, k - 1);
        return data[k - 1];
    }
    private void quickSelectNthElement(int[] data, int left, int right, int kth) {
        if(left == right) {
            return;
        }
        int eql = left - 1, eqr = left - 1;
        int pivot = (int)(Math.random() * (right - left + 1) + left);
        swap(data, pivot, right);
        for (int i = left; i <= right; i++) {
            if(data[i] > data[right]) {
                swap(data, i, ++eqr);
                swap(data, ++eql, eqr);
            } else if(data[i] == data[right]) {
                swap(data, i, ++eqr);
            }
        }
        if(eql < left + kth && eqr >= left + kth) {
            return;
        } else if(eql >= left + kth) {
            quickSelectNthElement(data, left, eql, kth);
        } else {
            quickSelectNthElement(data, eqr + 1, right, kth - (eqr - left + 1));
        }

    }
    private void swap(int[] data, int i, int j) {
        if(i >= data.length || j >= data.length) {
            return;
        }
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
