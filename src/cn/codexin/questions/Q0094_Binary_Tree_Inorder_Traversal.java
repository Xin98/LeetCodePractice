package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/9/14
 */

public class Q0094_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            }
            else if(!stack.isEmpty()) {
                p = stack.pop();
                ans.add(p.val);
                p = p.right;
            }
        }
        return ans;
    }
}
