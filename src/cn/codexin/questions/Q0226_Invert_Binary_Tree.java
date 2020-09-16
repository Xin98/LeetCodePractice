package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/16
 */

public class Q0226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
