package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/23
 */

public class Q0617_Merge_Two_Binary_Trees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        TreeNode leftMergedTree = mergeTrees(t1.left, t2.left);
        TreeNode rightMergedTree = mergeTrees(t1.right, t2.right);
        t1.val = t1.val + t2.val;
        t1.left = leftMergedTree;
        t1.right = rightMergedTree;
        return t1;
    }
}
