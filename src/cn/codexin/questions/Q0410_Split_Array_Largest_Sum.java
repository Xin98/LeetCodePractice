package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/25
 */

public class Q0410_Split_Array_Largest_Sum {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    // 应该可以用二分查找优化
                    int curValue = Math.max(dp[k][j-1], prefixSum[i] - prefixSum[k]);
                    //int minValue = findMinValue(prefixSum, dp, i, j);
                    dp[i][j] = Math.min(dp[i][j], curValue);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * dp[i][j] 具有单调性   dp[i+1][j] >= dp[i][j] 利用其单调性来二分查找
     * @param prefixSum
     * @param dp
     * @param n 数组长度
     * @param m 需要拆分的个数  m >= 1
     * @return
     */
    private int findMinValue(int[] prefixSum, int[][] dp, int n, int m) {
        int left = 0;
        int right = n - 1;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(dp[mid][m-1] > (prefixSum[n] - prefixSum[mid])) {
                right = mid - 1;
            } else if(dp[mid][m-1] < (prefixSum[n] - prefixSum[mid])){
                left = mid + 1;
            } else {
                return dp[mid][m-1];
            }
        }
        int leftValue = left < n ? Math.max(dp[left][m-1], prefixSum[n] - prefixSum[left]) : Integer.MAX_VALUE;
        int rightValue = right >= 0 ? Math.max(dp[right][m-1], prefixSum[n] - prefixSum[right]) : Integer.MAX_VALUE;
        return Math.min(leftValue, rightValue);
    }

    public static void main(String[] args) {
        Q0410_Split_Array_Largest_Sum Q = new Q0410_Split_Array_Largest_Sum();
        System.out.println(Q.splitArray(new int[]{1,4,4}, 3));
    }
}
