package cn.codexin.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinGao 2020/8/12
 */

public class Q0133_Clone_Graph {
    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node cloneNode = new Node(node.val);
        map.put(cloneNode.val, cloneNode);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
