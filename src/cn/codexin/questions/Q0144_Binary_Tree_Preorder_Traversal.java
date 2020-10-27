package cn.codexin.questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/10/27
 */

public class Q0144_Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return ans;
    }
}
