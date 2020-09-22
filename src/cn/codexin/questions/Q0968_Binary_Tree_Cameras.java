package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/22
 */

public class Q0968_Binary_Tree_Cameras {
    public int minCameraCover(TreeNode root) {
        int[] dp = dfs(root);
        return dp[1];
    }
    public int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] dp = new int[3];
        dp[0] = left[2] + right[2] + 1;
        dp[1] = Math.min(dp[0], Math.min(left[0] + right[1], left[1] + right[0]));
        dp[2] = Math.min(dp[0], left[1] + right[1]);
        return dp;
    }
}
