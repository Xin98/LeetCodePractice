package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xinGao 2020/4/22
 */

public class Q0199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0;i < count; i++){
                TreeNode node = queue.poll();
                if(i == 0){
                    ans.add(node.val);
                }
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
            }
        }

        return ans;
    }
}

