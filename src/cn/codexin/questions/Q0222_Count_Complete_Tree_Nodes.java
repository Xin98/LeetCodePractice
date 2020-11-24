package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/24
 */

public class Q0222_Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int level = 0;
        TreeNode cur = root;
        while(cur.left != null) {
            cur = cur.left;
            level++;
        }
        int low = 1 << level;
        int high = (1 << (level + 1)) - 1;
        while(low < high) {
            int mid = (high - low + 1) / 2 + low;
            if(exist(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    //e.g., level = 5, low = 32, high = 63 ==> 0 ~ 31 ==> 16(10000) 8(01000) 4(00100) 2(00010) 1(00001)
    public boolean exist(TreeNode root, int level, int pos) {
        int bit = 1 << (level - 1);
        while(bit > 0) {
            if((pos & bit) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            if(root == null) {
                return false;
            }
            bit >>= 1;
        }
        return true;
    }
}
