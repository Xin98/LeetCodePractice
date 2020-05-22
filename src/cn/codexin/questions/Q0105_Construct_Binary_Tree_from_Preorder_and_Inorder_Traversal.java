package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/5/22
 */

public class Q0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    private int[] preorder;
    private int[] inoder;
    private Map<Integer, Integer> idxOfInOrder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inoder = inorder;
        int len = inorder.length;
        idxOfInOrder = new HashMap<>();
        for(int i = 0; i < len; i++) {
            idxOfInOrder.put(inorder[i], i);
        }
        return builder(0, len-1, 0, len-1);
    }
    public TreeNode builder(int preL, int preR, int inL, int inR) {
        if(preL > preR) return null;
        TreeNode head = new TreeNode(preorder[preL]);
        int leftChildLen = idxOfInOrder.get(preorder[preL]) - inL;
        head.left = builder(preL + 1, preL + leftChildLen, inL, inL + leftChildLen - 1);
        head.right = builder(preL + leftChildLen + 1, preR, inL + leftChildLen + 1, inR);
        return head;
    }
}
