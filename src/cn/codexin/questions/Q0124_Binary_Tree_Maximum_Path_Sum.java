package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/21
 */

public class Q0124_Binary_Tree_Maximum_Path_Sum {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        getMaxSumByRoot(root);
        return ans;
    }
    public int getMaxSumByRoot(TreeNode root) {
        if(root == null) return 0;
        int curVal = root.val;
        int leftVal = Math.max(0, getMaxSumByRoot(root.left));
        int rightVal = Math.max(0, getMaxSumByRoot(root.right));
        int sumVal = curVal + leftVal + rightVal;
        ans = Math.max(ans, sumVal);
        return curVal + Math.max(leftVal, rightVal);
    }
}
