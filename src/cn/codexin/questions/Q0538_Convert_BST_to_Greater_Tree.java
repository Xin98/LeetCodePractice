package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2020/9/22
 */

public class Q0538_Convert_BST_to_Greater_Tree {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null){
            if(p != null) {
                stack.push(p);
                p = p.right;
            } else {
                p = stack.pop();
                int tmp = p.val;
                p.val += sum;
                sum += tmp;
                p = p.left;
            }
        }
        return root;
    }
}
