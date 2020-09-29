package cn.codexin.questions;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/9/29
 */

public class Q0145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                ans.add(p.val);
                stack.push(p);
                p = p.right;
            } else {
                p = stack.pop();
                p = p.left;
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
