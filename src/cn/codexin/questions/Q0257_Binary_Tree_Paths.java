package cn.codexin.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by xinGao 2020/9/4
 */

public class Q0257_Binary_Tree_Paths {
    private List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(root, path);
        return ans;
    }
    public void dfs(TreeNode root, List<String> path) {
        if(root == null) {
            return;
        }
        path.add(String.valueOf(root.val));
        if(root.left == null && root.right == null) {
            String res = path.stream().reduce((x, y) -> (x + "->" + y)).get();
            ans.add(res);
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size()-1);
    }
}
