package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/18
 */
public class QInterview0412_Paths_with_Sum {
    class Solution {
        private int ans = 0;
        public int pathSum(TreeNode root, int sum) {
            if(root == null) return 0;
            helper(root, sum);
            return ans;
        }
        public void helper(TreeNode root, int sum){
            if(root == null) return;
            helperWithRoot(root, sum);
            helper(root.left, sum);
            helper(root.right, sum);
        }
        public void helperWithRoot(TreeNode root, int sum){
            if(root == null) return;
            if(sum == root.val) ans++;
            helperWithRoot(root.left, sum-root.val);
            helperWithRoot(root.right, sum-root.val);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}