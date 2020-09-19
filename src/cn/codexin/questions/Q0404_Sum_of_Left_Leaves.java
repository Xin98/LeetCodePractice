package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/19
 */

public class Q0404_Sum_of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return helper(root, false);
    }
    public int helper(TreeNode node, boolean isLeft) {
        if(node == null) {
            return 0;
        }
        if(isLeft && node.left == null && node.right == null) {
            return node.val;
        }
        return helper(node.left, true) + helper(node.right, false);
    }
}
