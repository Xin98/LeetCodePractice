package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/17
 */

public class Q0110_Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isBalanced(root.left) || !isBalanced(root.right) || Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        return true;
    }

    public int getDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
