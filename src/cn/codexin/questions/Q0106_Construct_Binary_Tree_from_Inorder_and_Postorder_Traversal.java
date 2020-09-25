package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/25
 */

public class Q0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int l1, int r1, int l2, int r2) {
        if(l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[r2]);
        for(int i = l1; i <= r1; i++) {
            if(inorder[i] == postorder[r2]) {
                root.left = helper(inorder, postorder, l1, i-1, l2, l2 + i - 1 - l1);
                root.right = helper(inorder, postorder, i + 1, r1, l2 + i - l1, r2 - 1);
                break;
            }
        }
        return root;
    }
}
