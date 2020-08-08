package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/8
 */

public class Q0099_Recover_Binary_Search_Tree {
    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor = null;
        while (root != null) {
            if(root.left != null) {
                predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                else {
                    if(pred != null && pred.val > root.val) {
                        y = root;
                        if(x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                if(pred != null && pred.val > root.val) {
                    y = root;
                    if(x == null) {
                        x = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x, y);
    }
    public void swap(TreeNode x, TreeNode y) {
        int val = x.val;
        x.val = y.val;
        y.val = val;
    }
}
