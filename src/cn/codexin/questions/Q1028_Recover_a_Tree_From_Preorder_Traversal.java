package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2020/6/18
 */

public class Q1028_Recover_a_Tree_From_Preorder_Traversal {
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> queue = new LinkedList<>();
        int pos = 0;
        int sLen = S.length();
        while(pos < sLen) {
            int level = 0;
            while (pos < sLen && S.charAt(pos) == '-') {
                level++;
                pos++;
            }
            int value = 0;
            while(pos < sLen && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + S.charAt(pos++) - '0';
            }
            TreeNode node = new TreeNode(value);
            if(level == queue.size()) {
                if(!queue.isEmpty()) {
                    queue.peek().left = node;
                }
            } else {
                while(level != queue.size()){
                    queue.poll();
                }
                queue.peek().right = node;
            }
            queue.push(node);
        }
        while(queue.size() > 1) queue.poll();
        return queue.peek();
    }
}
