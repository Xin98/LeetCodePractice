package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/7/21
 */

public class Q0095_Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> allTrees = new LinkedList<>();
        if(left > right) {
            allTrees.add(null);
            return allTrees;
        }
        for(int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = generateTrees(left, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, right);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = leftTree;
                    curTree.right = rightTree;
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }
}
