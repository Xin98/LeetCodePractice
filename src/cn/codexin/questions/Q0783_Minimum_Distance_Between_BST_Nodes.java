package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/13
 */

public class Q0783_Minimum_Distance_Between_BST_Nodes {
    public int minDiffInBST(TreeNode root) {
        TreeNode predecessor = null, lastVisitedNode = null;
        int ans = Integer.MAX_VALUE;
        while(root != null) {
            if(root.left != null) {
                predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    predecessor.right = null;
                    if(lastVisitedNode != null) {
                        ans = Math.min(ans, Math.abs(root.val - lastVisitedNode.val));
                    }
                    lastVisitedNode = root;
                    root = root.right;
                }
            } else {
                if(lastVisitedNode != null) {
                    ans = Math.min(ans, Math.abs(root.val - lastVisitedNode.val));
                }
                lastVisitedNode = root;
                root = root.right;
            }
        }
        return ans;
    }
}
