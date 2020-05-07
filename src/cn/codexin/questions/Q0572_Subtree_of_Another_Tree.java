package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/7
 */

public class Q0572_Subtree_of_Another_Tree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null) return true;
        if(s == null) return false;
        if(isEqual(s, t)) return true;
        if(isSubtree(s.left, t) || isSubtree(s.right, t)) return true;
        return false;
    }

    private boolean isEqual(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right)) return true;
        return false;
    }
}
