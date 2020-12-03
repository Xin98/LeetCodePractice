package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/3
 */

public class QInterview0406_Successor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return null;
        }
        TreeNode ans = null;
        if(root.val > p.val) {
            ans = inorderSuccessor(root.left, p);
            if(ans == null) {
                return root;
            }
            return ans;
        }
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        return ans;
    }
}
