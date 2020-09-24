package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/9/24
 */

public class Q0865_Smallest_Subtree_with_all_the_Deepest_Nodes {
    // 自顶向下解法
    private Map<TreeNode, Integer> memo  = new HashMap<>();;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) {
            return root;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(leftDepth == rightDepth) {
            return root;
        } else if(leftDepth > rightDepth) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }
    public int getDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        if(memo.containsKey(node)) {
            return memo.get(node);
        }
        memo.put(node, Math.max(getDepth(node.left), getDepth(node.right)) + 1);
        return memo.get(node);
    }
}
