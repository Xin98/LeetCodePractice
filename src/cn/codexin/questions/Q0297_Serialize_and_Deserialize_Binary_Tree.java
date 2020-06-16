package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/6/16
 */

public class Q0297_Serialize_and_Deserialize_Binary_Tree {
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> ans = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root == null) return "[]";
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node != null) {
                    ans.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    ans.add("null");
                }
            }
            return "[" + String.join(",", ans) + "]";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.substring(1, data.length() - 1);
            if(data.length() == 0) return null;
            String[] treeArr = data.split(",");
            int n = treeArr.length;
            TreeNode head = new TreeNode(Integer.valueOf(treeArr[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(head);
            int idx = 1;
            while(idx < n) {
                TreeNode node = queue.poll();
                if(!"null".equals(treeArr[idx])) {
                    node.left = new TreeNode(Integer.valueOf(treeArr[idx]));
                    queue.offer(node.left);
                }
                idx++;
                if(!"null".equals(treeArr[idx])) {
                    node.right = new TreeNode(Integer.valueOf(treeArr[idx]));
                    queue.offer(node.right);
                }
                idx++;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        String code = codec.serialize(null);
        codec.deserialize(code);
    }
}
