package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/4/25
 */

public class Q0897_Increasing_Order_Search_Tree {
    public TreeNode increasingBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root, dummy = new TreeNode(0);
        TreeNode last = dummy;
        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                last.right = cur;
                cur.left = null;
                last = cur;
                cur = cur.right;
            }
        }
        return dummy.right;
    }
}
