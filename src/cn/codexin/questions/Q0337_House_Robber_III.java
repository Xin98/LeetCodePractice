package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/8/5
 */

public class Q0337_House_Robber_III {
    private Map<TreeNode, Integer> f = new HashMap<>();
    private Map<TreeNode, Integer> g = new HashMap<>();
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }
    public void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(node.val + g.getOrDefault(node.left, 0),f.getOrDefault(node.left, 0)) +
                Math.max(g.getOrDefault(node.right, 0),f.getOrDefault(node.right, 0)));

    }
}
