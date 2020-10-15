package cn.codexin.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinGao 2020/10/15
 */

public class Q0116_Populating_Next_Right_Pointers_in_Each_Node {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            while(n-- > 0) {
                Node cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                if(n > 0) {
                    cur.next = queue.peek();
                } else {
                    cur.next = null;
                }
            }
        }
        return root;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
