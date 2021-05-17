package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/17
 */

public class Q0993_Cousins_in_Binary_Tree {
    // dfs
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xInfo = getNodeInfo(root, x, 0, -1);
        int[] yInfo = getNodeInfo(root, y, 0, -1);
        return xInfo[0] != yInfo[0] && xInfo[1] == yInfo[1];
    }
    public int[] getNodeInfo(TreeNode root, int n, int depth, int parent) {
        if(root == null) {
            return null;
        }
        if(root.val == n) {
            return new int[] {parent, depth};
        }
        int[] left = getNodeInfo(root.left, n, depth + 1, root.val);
        if(left != null) {
            return left;
        }
        int[] right = getNodeInfo(root.right, n, depth + 1, root.val);
        if(right != null) {
            return right;
        }
        return null;
    }
}
