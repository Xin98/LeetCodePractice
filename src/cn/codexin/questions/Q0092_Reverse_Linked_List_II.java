package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/18
 */

public class Q0092_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        // find first need reverse node's head
        for(int i = 1; i < left; i++) {
            p = p.next;
        }
        ListNode t = p.next;
        ListNode h = t;
        for(int i = left; i < right; i++) {
            h = t.next;
            t.next = h.next;
            h.next = p.next;
            p.next = h;
        }
        return dummy.next;
    }
}
