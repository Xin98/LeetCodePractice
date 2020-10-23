package cn.codexin.questions;

import java.util.List;

/**
 * Created by xinGao 2020/10/23
 */

public class Q0559_Maximum_Depth_of_N_ary_Tree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.children == null) {
            return 1;
        }
        int max = 1;
        for(Node node : root.children) {
            max = Math.max(max, maxDepth(node) + 1);
        }
        return max;
    }
}
