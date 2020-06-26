package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/26
 */

public class QInterview_0201_Remove_Duplicate_Node {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur;
            while(next.next != null) {
                if(next.next.val == cur.val) {
                    next.next = next.next.next;
                } else {
                    next = next.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
