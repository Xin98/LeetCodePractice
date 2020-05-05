package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2020/5/5
 */

public class Q0098_Validate_Binary_Search_Tree {
    //方法1：递归
//    public boolean isValidBST(TreeNode root) {
//        if(root == null) return true;
//        if(!isValidBST(root.left) || !isValidBST(root.right)) return false;
//        TreeNode leftMax = root.left, rightMin = root.right;
//        while(leftMax != null){
//            if(leftMax.right != null) leftMax = leftMax.right;
//            else break;
//        }
//        while(rightMin != null){
//            if(rightMin.left != null) rightMin = rightMin.left;
//            else break;
//        }
//        if(leftMax != null && leftMax.val >= root.val) return false;
//        if(rightMin != null && rightMin.val <= root.val) return false;
//        return true;
//    }
    //中序遍历
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        int pre = Integer.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else{
                root = stack.pop();
                if(pre >= root.val) return false;
                pre = root.val;
                root = root.right;
            }

        }
        return true;
    }
}
