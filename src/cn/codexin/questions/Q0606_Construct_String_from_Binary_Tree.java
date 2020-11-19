package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/19
 */

public class Q0606_Construct_String_from_Binary_Tree {
    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        if(t.left == null && t.right == null) {
            return t.val + "";
        }
        if(t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}
