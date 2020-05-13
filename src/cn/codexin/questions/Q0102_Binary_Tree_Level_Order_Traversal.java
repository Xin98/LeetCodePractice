package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xinGao 2020/5/13
 */

public class Q0102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> res = new LinkedList<>();
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ans.add(res);
        }
        return ans;
    }
}
