package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/28
 */

public class Q0988_Smallest_String_Starting_From_Leaf {
    private String ans;
    public String smallestFromLeaf(TreeNode root) {
        ans = "~";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        sb.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null) {
            String s = sb.reverse().toString();
            sb.reverse();
            if(s.compareTo(ans) < 0) {
                ans = s;
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

}
