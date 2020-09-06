package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/9/6
 */

public class Q0107_Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> res = new ArrayList<>();
            while(n > 0) {
                n--;
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                res.add(node.val);
            }
            ans.add(res);
        }
        Collections.reverse(ans);
        return ans;
    }
}
