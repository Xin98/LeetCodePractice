package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/3/28
 */

public class Q0173_Binary_Search_Tree_Iterator {
    class BSTIterator {
        private Deque<TreeNode> stack;
        private TreeNode cur;
        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            cur = root;
        }

        public int next() {
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int v = cur.val;
            cur = cur.right;
            return v;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
