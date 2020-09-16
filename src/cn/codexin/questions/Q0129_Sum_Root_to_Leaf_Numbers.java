package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/16
 */

public class Q0129_Sum_Root_to_Leaf_Numbers {
    private int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode root, int num) {
        if(root == null) {
            return;
        }
        num = num * 10 + root.val;
        if(root.left == null && root.right == null) {
            ans += num;
            return;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }
}
