package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2020/10/12
 */

public class Q0530_Minimum_Absolute_Difference_in_BST {
    //法1: 常规中序遍历
//    public int getMinimumDifference(TreeNode root) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        TreeNode p = root, q = null;
//        int ans = Integer.MAX_VALUE;
//        while(!stack.isEmpty() || p != null) {
//            if(p != null) {
//                stack.push(p);
//                p = p.left;
//            } else {
//                p = stack.pop();
//                if(q != null) {
//                    ans = Math.min(ans, p.val - q.val);
//                }
//                q = p;
//                p = p.right;
//            }
//        }
//        return ans;
//    }
    // Morris
    public int getMinimumDifference(TreeNode root) {
        TreeNode predecessor = null, lastVisitedNode = null;
        int ans = Integer.MAX_VALUE;
        while(root != null){
            if(root.left != null) {
                predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    predecessor.right = null;
                    if(lastVisitedNode != null) {
                        ans = Math.min(ans, root.val - lastVisitedNode.val);
                    }
                    lastVisitedNode = root;
                    root = root.right;
                }
            } else {
                if(lastVisitedNode != null) {
                    ans = Math.min(ans, root.val - lastVisitedNode.val);
                }
                lastVisitedNode = root;
                root = root.right;
            }
        }
        return ans;
    }
}
