package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xinGao 2020/12/22
 */

public class Q0103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        queue.offer(root);
        boolean left2right = true;
        while(!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(left2right) {
                    tmp.add(node.val);
                } else {
                    tmp.add(0, node.val);
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            left2right = !left2right;
            ans.add(tmp);
        }
        return ans;
    }
}
