package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/10
 */

public class Q0236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null ? (right != null ? root : left) : right;
    }
}
