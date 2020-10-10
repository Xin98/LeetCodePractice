package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/10
 */

public class Q1325_Delete_Leaves_With_a_Given_Value {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
