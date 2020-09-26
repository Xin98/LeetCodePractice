package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/9/26
 */

public class Q0113_Path_Sum_II {
    private List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new LinkedList<>();
        dfs(new LinkedList<>(), root, sum);
        return ans;
    }
    public void dfs(List<Integer> path, TreeNode node, int target) {
        if(node == null) {
            return;
        }
        path.add(node.val);
        if(node.left == null && node.right == null && target == node.val) {
            ans.add(new LinkedList<>(path));
        } else {
            dfs(path, node.left, target - node.val);
            dfs(path, node.right, target - node.val);
        }
        path.remove(path.size() - 1);
    }
}
