package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xinGao 2021/6/30
 */

public class QSword0037_Serialize_Binary_Tree {
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) {
                return "";
            }
            List<String> serial = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node == null) {
                    serial.add("null");
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    serial.add(String.valueOf(node.val));
                }
            }
            while (!serial.isEmpty()) {
                if(serial.get(serial.size() - 1).equals("null")) {
                    serial.remove(serial.size() - 1);
                } else {
                    break;
                }
            }
            return serial.stream().reduce((a, b) -> a + "," + b).get();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] node = data.split(",");
            if(data == null || data.isEmpty() || data.equals("null")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(node[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int cur = 1;
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                if(cur >= node.length) {
                    break;
                }
                if(!node[cur].equals("null")) {
                    p.left = new TreeNode(Integer.valueOf(node[cur]));
                    queue.offer(p.left);
                }
                cur++;
                if(cur >= node.length) {
                    break;
                }
                if(!node[cur].equals("null")) {
                    p.right = new TreeNode(Integer.valueOf(node[cur]));
                    queue.offer(p.right);
                }
                cur++;
            }
            return root;

        }
    }
}
