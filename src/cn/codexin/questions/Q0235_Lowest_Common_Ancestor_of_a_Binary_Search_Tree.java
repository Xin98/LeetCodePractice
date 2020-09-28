package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/28
 */

public class Q0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        if(root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }
}
