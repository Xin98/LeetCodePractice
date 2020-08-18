package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/18
 */

public class Q0109_Convert_Sorted_List_to_Binary_Search_Tree {
    private ListNode globalNode;
    public TreeNode sortedListToBST(ListNode head) {
        globalNode = head;
        return buildTree(0, getLength(head) - 1);
    }

    public int getLength(ListNode head) {
        int cnt = 0;
        for (; head != null; head = head.next, cnt++);
        return cnt;
    }

    public TreeNode buildTree(int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (right - left) / 2 + left;
        TreeNode head = new TreeNode(0);
        head.left = buildTree(left, mid - 1);
        head.val = globalNode.val;
        globalNode = globalNode.next;
        head.right = buildTree(mid + 1, right);
        return head;
    }
}
