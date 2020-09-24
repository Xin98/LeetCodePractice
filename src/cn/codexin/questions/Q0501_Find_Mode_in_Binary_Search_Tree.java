package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/9/24
 */

public class Q0501_Find_Mode_in_Binary_Search_Tree {
    private int lastValue;
    private int cnt;
    private int maxCnt;
    private List<Integer> ans;
    public int[] findMode(TreeNode root) {
        int cnt = 0;
        int maxCnt = -1;
        ans = new LinkedList<>();
        TreeNode cur = root, pre;
        while(cur != null) {
            if(cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while(pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if(pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                update(cur.val);
                cur = cur.right;
                pre.right = null;
            }

        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
    public void update(int x) {
        if(x == lastValue) {
            cnt++;
        } else {
            lastValue = x;
            cnt = 1;
        }
        if(cnt == maxCnt) {
            ans.add(x);
        }
        if(cnt > maxCnt) {
            ans.clear();
            ans.add(x);
            maxCnt = cnt;
        }
    }
}
