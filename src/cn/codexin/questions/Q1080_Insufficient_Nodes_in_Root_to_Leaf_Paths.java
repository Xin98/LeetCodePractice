package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/5
 */

public class Q1080_Insufficient_Nodes_in_Root_to_Leaf_Paths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null && root.val < limit) {
            // 叶子节点
            return null;
        }
        TreeNode left = sufficientSubset(root.left, limit - root.val);
        TreeNode right = sufficientSubset(root.right, limit - root.val);
        if((root.left != null || root.right != null) && (left == null && right == null)) {
            // 非叶子节点 处理后变成了叶子节点那么该节点也需要被删除
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
