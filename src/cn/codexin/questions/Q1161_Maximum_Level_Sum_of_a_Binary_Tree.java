package cn.codexin.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinGao 2020/7/26
 */

public class Q1161_Maximum_Level_Sum_of_a_Binary_Tree {
    public int maxLevelSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            level++;
            int sum = 0;
            while(n > 0) {
                n--;
                TreeNode node = queue.poll();
                if(node.left !=  null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                sum += node.val;
            }
            if(sum > max) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}
