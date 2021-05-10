package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/5/10
 */

public class Q0872_Leaf_Similar_Trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new LinkedList<>();
        dfs(root1, seq1);
        List<Integer> seq2 = new LinkedList<>();
        dfs(root2, seq2);
        if(seq1.equals(seq2)){
            return true;
        }
        return false;
    }

    public void dfs(TreeNode root, List<Integer> seq) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            dfs(root.left, seq);
        }
        if(root.right != null) {
            dfs(root.right, seq);
        }
        if(root.left == null && root.right == null) {
            seq.add(root.val);
        }
    }
}
