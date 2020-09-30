package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/30
 */

public class Q0701_Insert_into_a_Binary_Search_Tree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if(val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
