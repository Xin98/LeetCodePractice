package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/2
 */

public class Q0114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}
