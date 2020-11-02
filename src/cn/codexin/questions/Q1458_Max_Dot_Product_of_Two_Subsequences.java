package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/2
 */

public class Q1458_Max_Dot_Product_of_Two_Subsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                int product = nums1[i-1] * nums2[j-1];
                max = Math.max(max, product);
                dp[i][j] = dp[i-1][j-1] + product;
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return max > 0? dp[len1][len2]: max;
    }
}
