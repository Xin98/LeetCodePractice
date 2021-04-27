package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/27
 */

public class Q0938_Range_Sum_of_BST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        if(root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else if(root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else{
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }
}
